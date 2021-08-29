import java.io.File;
import java.util.ArrayList;

public class Cube
{
    public static int count = 0;

    public int              size;
    public ArrayList<Side>  sides = new ArrayList<>();

    public int LU;
    public int RU;
    public int LD;
    public int RD;

    public int  C;

    public int L;
    public int R;
    public int D;
    public int U;

    public class Side
    {
        public byte position;
        public ArrayList<Byte> field = new ArrayList<>();

        public Side(byte position)
        {
            this.position = position;
        }
    }

    public Cube(int size)
    {
        this.size = size;

        for (byte i = 0; i < 6; i++)
            fill_side(i);

        LU = 0;
        RU = this.size - 1;
        LD = this.size * (this.size - 1);
        RD = this.size * this.size - 1;
        C = this.size + 1;
        L = this.size;
        R = this.size * 2 - 1;
        D = this.size * this.size - 2;
        U = 1;
    }

    public void fill_side(byte position)
    {
        sides.add(new Side(position));
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                sides.get(position).field.add(
                        position);
            }
        }
    }

    public void show_cube()
    {
        int i = 0;
        for (byte b : sides.get(0).field)
        {
            if (i % size == 0)
            {
                if (i != 0)
                    System.out.print("\n");
                System.out.print(get_interval(size));
            }

            System.out.print(Side_color.get_color(b) + "__|" + Side_color.RESET);
            i++;
        }
        System.out.print("\n");
        for (int j = 0; j < size; j++)
        {
            for (Side side : sides)
            {
                if (side.position == 0 || side.position == 5)
                    continue;
                for (int x = 0; x < size; x++)
                {
                    System.out.print(Side_color.get_color(side.field.get(j * size + x)) + "__|" + Side_color.RESET);
                }
            }
            System.out.print("\n");
        }
        i = 0;
        for (byte b : sides.get(5).field)
        {
            if (i % size == 0)
            {
                if (i != 0)
                    System.out.print("\n");
                System.out.print(get_interval(size));
            }

            System.out.print(Side_color.get_color(b) + "__|" + Side_color.RESET);
            i++;
        }
        System.out.print("\n\n");
    }

    public boolean oper(byte operation)
    {
        return oper(operation, 0, new File("solve"));
    }
    public boolean oper(byte operation, File file)
    {
        return oper(operation, 0, file);
    }

    public boolean oper(byte operation, int degree, File file)
    {
        count++;
        switch (operation) {
            case 0 :
            {
                main.addStr("L", file);
                Operations.L(this, degree);
                break ;
            }
            case 1 :
            {
                main.addStr("L_", file);
                Operations.L_(this, degree);
                break ;
            }
            case 2 :
            {
                main.addStr("R", file);
                Operations.R(this, degree);
                break ;
            }
            case 3 :
            {
                main.addStr("R_", file);
                Operations.R_(this, degree);
                break ;
            }
            case 4 :
            {
                main.addStr("U", file);
                Operations.U(this, degree);
                break ;
            }
            case 5 :
            {
                main.addStr("U_", file);
                Operations.U_(this, degree);
                break ;
            }
            case 6 :
            {
                main.addStr("D", file);
                Operations.D(this, degree);
                break ;
            }
            case 7 :
            {
                main.addStr("D_", file);
                Operations.D_(this, degree);
                break ;
            }
            case 8 :
            {
                main.addStr("F", file);
                Operations.F(this, degree);
                break ;
            }
            case 9 :
            {
                main.addStr("F_", file);
                Operations.F_(this, degree);
                break ;
            }
            case 10 :
            {
                main.addStr("B", file);
                Operations.B(this, degree);
                break ;
            }
            case 11 :
            {
                main.addStr("B_", file);
                Operations.B_(this, degree);
                break ;
            }
        }
        return true;
    }

    public boolean is_solved()
    {
        for (Side side : sides)
        {
            int count = 0;
            byte buf = -1;
            for (byte b : side.field)
            {
                if (count++ == 0)
                    buf = b;
                else
                    if (buf != b)
                        return false;
            }
        }
        return true;
    }

    public String get_interval(int size)
    {
        String str = "";
        for (int i = 0; i < size * 3; i++)
            str += " ";
        return str;
    }

    public static class Side_color
    {
        public static final String RESET = "\u001B[0m";

        public static String get_color(byte value)
        {
            return "\u001B[4" + value + "m";
        }
    }
}
