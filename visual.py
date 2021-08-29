from ursina import *


class Game(Ursina):
    def __init__(self):
        super().__init__()
        Entity(model='sphere', scale=100, texture='textures/stars',
               double_sided=True)
        EditorCamera(rotation=(30, -30, 0), scale=1.5)
        Audio(sound_file_name='music/Mortal Kombat', autoplay=True)
        self.time_animation = 0.0001
        self.PARENT = Entity()

        self.k = 0
        self.action = False
        self.rotation_axes = {'LEFT': 'x',
                              'RIGHT': 'x',
                              'UP': 'y',
                              'BACK': 'z',
                              'FRONT': 'z',
                              'DOWN': 'y'}
        self.commands = {'L': ('LEFT', -90), 'L_': ('LEFT', 90),
                         'R': ('RIGHT', 90), 'R_': ('RIGHT', -90),
                         'F': ('FRONT', 90), 'F_': ('FRONT', -90),
                         'U': ('UP', 90), 'U_': ('UP', -90),
                         'B': ('BACK', -90), 'B_': ('BACK', 90),
                         'D': ('DOWN', -90), 'D_': ('DOWN', 90)
                         }
        self.create_cube_positions()
        self.create_cubes()

    def create_cubes(self):
        self.CUBES = [Entity(model='models/cube', texture='textures/cube',
                      position=position) for position in self.SIDES]
        invoke(self.run_game, "commands", delay=3)

    def rotate_side(self, side_name, direction):
        cube_positions = self.cubes_sides[side_name]
        rotation_axis = self.rotation_axes[side_name]
        self.change_parent()
        for cube in self.CUBES:
            if cube.position in cube_positions:
                cube.parent = self.PARENT
                if rotation_axis == 'z':
                    invoke(self.PARENT.animate_rotation_z, direction,
                           duration=self.time_animation)
                elif rotation_axis == 'y':
                    invoke(self.PARENT.animate_rotation_y, direction,
                           duration=self.time_animation)
                else:
                    invoke(self.PARENT.animate_rotation_x, direction,
                           duration=self.time_animation)

    def change_parent(self):
        for cube in self.CUBES:
            if cube.parent == self.PARENT:
                world_pos = round(cube.world_position, 1)
                world_rot = cube.world_rotation
                cube.parent = scene
                cube.position, cube.rotation = world_pos, world_rot
        self.PARENT.rotation = 0

    def create_cube_positions(self):
        self.LEFT = [Vec3(-1, 0, 0), Vec3(-1, 1, -1), Vec3(-1, 0, 1),
                     Vec3(-1, -1, -1), Vec3(-1, 1, 0), Vec3(-1, 0, -1),
                     Vec3(-1, -1, 1), Vec3(-1, -1, 0), Vec3(-1, 1, 1)]
        self.DOWN = [Vec3(0, -1, 1), Vec3(-1, -1, -1), Vec3(1, -1, 0),
                     Vec3(1, -1, 1), Vec3(0, -1, 0), Vec3(1, -1, -1),
                     Vec3(-1, -1, 1), Vec3(-1, -1, 0), Vec3(0, -1, -1)]
        self.FRONT = [Vec3(0, 1, -1), Vec3(1, 0, -1), Vec3(-1, 1, -1),
                      Vec3(-1, -1, -1), Vec3(1, 1, -1), Vec3(-1, 0, -1),
                      Vec3(0, 0, -1), Vec3(1, -1, -1), Vec3(0, -1, -1)]
        self.BACK = [Vec3(0, 1, 1), Vec3(0, -1, 1), Vec3(-1, 0, 1),
                     Vec3(1, -1, 1), Vec3(1, 0, 1), Vec3(0, 0, 1),
                     Vec3(-1, -1, 1), Vec3(1, 1, 1), Vec3(-1, 1, 1)]
        self.RIGHT = [Vec3(1, 0, -1), Vec3(1, -1, 0), Vec3(1, 1, -1),
                      Vec3(1, -1, 1), Vec3(1, 0, 0), Vec3(1, 1, 1),
                      Vec3(1, -1, -1), Vec3(1, 0, 1), Vec3(1, 1, 0)]
        self.UP = [Vec3(0, 1, 1), Vec3(-1, 1, -1), Vec3(1, 1, -1),
                   Vec3(-1, 1, 0), Vec3(1, 1, 1), Vec3(1, 1, 0),
                   Vec3(0, 1, 0), Vec3(0, 1, -1), Vec3(-1, 1, 1)]
        self.cubes_sides = {'LEFT': self.LEFT, 'DOWN': self.DOWN,
                            'UP': self.UP, 'BACK': self.BACK,
                            'RIGHT': self.RIGHT, 'FRONT': self.FRONT}
        self.SIDES = set(self.LEFT + self.DOWN + self.FRONT + self.BACK +
                         self.RIGHT + self.UP)

    def update(self, key, k):
        self.rotate_side(self.commands[key][0], self.commands[key][1])
        if k == self.k:
            self.action = True

    def run_game(self, filename):
        with open(filename, "r") as self.file:
            for self.line in self.file:
                self.s, self.c = self.line.split()
                self.c = int(self.c)
                for i in range(self.c):
                    self.k += 1
                    if filename == 'commands':
                        invoke(self.update, self.s, self.k, delay=0.2 * self.k)
                    else:
                        invoke(self.update, self.s, 0, delay=0.2 * self.k)

    def input(self, key):
        if self.action and key == 'enter':
            self.action = False
            self.time_animation = 0.1
            self.k = 0
            self.run_game("solve")
        super().input(key)


game = Game()
game.run()
