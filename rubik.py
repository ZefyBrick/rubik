from sys import argv
from argparse import ArgumentParser
import re
from time import sleep
from subprocess import call
import ctypes
if hasattr(ctypes, 'windll'):
    kernel32 = ctypes.windll.kernel32
    kernel32.SetConsoleMode(kernel32.GetStdHandle(-11), 7)


def get_arguments():
    parser = ArgumentParser(prog='rubik', description='''
    Программа собирает кубик Рубика. На вход подаётся комбинаия из действий,
    по которым кубик разбирается.
    Далее программа собирает его до исходного состояния''', add_help=True,
                            epilog='''
    (c) October 2020. Автор программы, как всегда, пусечка и лапочка.''')
    parser.add_argument('command', nargs='?')
    parser.add_argument('--v', '-v', action='store_const', const=True,
                        help='Визуализация')
    parser.add_argument('--random', '-random', action='store_const', const=True,
                        help='Генерация рандомных команд для разборки кубика')

    return parser


def parse(parser):
    namespace = parser.parse_args(argv[1:])
    viz, command, random = namespace.v, namespace.command, namespace.random
    return viz, command, random


def validate(command):
    links, sides, count = [], [], []
    spins = command.split()
    rules = 'R L D U B F'.split()
    for i in spins:
        if i[0] in ('-', '0'):
            print(f'Ошибка кодировки в команде {i}')
            exit()
        link = re.search(r'^\d+', i)
        if link and (int(link[0]) > 1):
            print(f'Слишком много сторон для поворота в {i}')
            exit()
        side = re.findall(r'[A-Z]+', i, flags=re.I)
        if not side or len(side) > 1 or side[0] not in rules:
            print(f'Ошибка в кодировке в команде {i}')
            exit()
        if i[: i.index(side[0])] and not i[: i.index(side[0])].isdigit():
            print(f'Ошибка в кодировке в команде {i}')
            exit()
        if (i[i.index(side[0]) + 1:] and not i[i.index(side[0]) + 1:].isdigit()
            and ((not i[i.index(side[0]) + 2:].isdigit() and
                 i[i.index(side[0]) + 2:] and i[i.index(side[0]) + 1] == '\'') or
                 (i[i.index(side[0]) + 1] != '\''))):
            print(f'Ошибка в кодировке в команде {i}')
            exit()
        links.append(link) if link else links.append(1)
        sides.append(side[0])
        if '\'' not in i:
            if i[i.index(side[0]) + 1:]:
                count.append(int(i[i.index(side[0]) + 1:]))
            else:
                count.append(1)
        else:
            sides[-1] += '_'
            if i[i.index('\'') + 1:]:
                count.append(int(i[i.index('\'') + 1:]))
            else:
                count.append(1)
    return links, sides, count


def main():
    parser = get_arguments()
    viz, command, random = parse(parser)
    if random and command is None:
        with open(r"commands", "w") as file:
            file.write('random\n')
    elif random and command:
        print('Слишком много параметров')
        exit()
    else:
        if not command:
            print('Команды не заданы!')
            exit()
        links, sides, count = validate(command)
        with open(r"commands", "w") as file:
            for s, c in zip(sides, count):
                file.write(str(s) + ' ' + str(c) + '\n')
    call(['java', '-classpath', './src', 'main'])
    if viz:
        sleep(3)
        call(['python', 'visual.py'])


if __name__ == '__main__':
    main()
