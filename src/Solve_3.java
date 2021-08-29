public class Solve_3
{
    public static int s0 = 0;
    public static int s1 = 0;
    public static int s2 = 0;
    public static int s3 = 0;
    public static int s4 = 0;
    public static int s5 = 0;
    public static int s6 = 0;
    public static int s7 = 0;

    public static void solve(Cube cube)
    {
        solve_cross(cube);
        s0 = Cube.count;
        solve_full_cross(cube);
        s1 = Cube.count;
        solve_1_layer(cube);
        s2 = Cube.count;
        solve_2_layer(cube);
        s3 = Cube.count;
        solve_down_cross(cube);
        s4 = Cube.count;
        right_angle_up(cube);
        s5 = Cube.count;
        solve_angle_up(cube);
        s6 = Cube.count;
        finish_solve(cube);
        s7 = Cube.count;
    }

    public static void solve_cross(Cube cube)
    {
        int color = 0;
        for (int i = 0; i < 5; i++)
        {
            if (cube.sides.get(i).field.get(cube.size * cube.size - 2) == color)
            {
                if (i == 0)
                {
                    while (cube.sides.get(5).field.get(1) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 8);
                    cube.oper((byte) 8);
                }
                if (i == 1)
                {
                    while (cube.sides.get(5).field.get(cube.size) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 1);
                    cube.oper((byte) 6);
                    cube.oper((byte) 9);
                }
                if (i == 2)
                {
                    cube.oper((byte) 8);
                    cube.oper((byte) 7);
                    cube.oper((byte) 0);
                }
                if (i == 3)
                {
                    cube.oper((byte) 2);
                    cube.oper((byte) 7);
                    cube.oper((byte) 8);
                }
                if (i == 4)
                {
                    cube.oper((byte) 10);
                    cube.oper((byte) 7);
                    cube.oper((byte) 3);
                }
                //System.out.println("низ " + i);
                solve_cross(cube);
            }
            if (cube.sides.get(i).field.get(1) == color)
            {
                if (i == 0)
                {
                    while (cube.sides.get(5).field.get(cube.size * cube.size - 2) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 10);
                    cube.oper((byte) 10);
                }
                if (i == 1)
                {
                    while (cube.sides.get(5).field.get(cube.size) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 0);
                    cube.oper((byte) 6);
                    cube.oper((byte) 9);
                }
                if (i == 2)
                {
                    while (cube.sides.get(5).field.get(1) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 8);
                    cube.oper((byte) 6);
                    cube.oper((byte) 3);
                }
                if (i == 3)
                {
                    while (cube.sides.get(5).field.get(cube.size * 2 - 1) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 3);
                    cube.oper((byte) 7);
                    cube.oper((byte) 8);
                }
                if (i == 4)
                {
                    while (cube.sides.get(5).field.get(cube.size * cube.size - 2) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 10);
                    cube.oper((byte) 6);
                    cube.oper((byte) 1);
                }
                //System.out.println("верх " + i);
                solve_cross(cube);
            }
            if (cube.sides.get(i).field.get(cube.size) == color)
            {
                if (i == 0)
                {
                    while (cube.sides.get(5).field.get(cube.size) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 0);
                    cube.oper((byte) 0);
                }
                if (i == 1)
                {
                    while (cube.sides.get(5).field.get(cube.size * cube.size - 2) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 10);
                }
                if (i == 2)
                {
                    while (cube.sides.get(5).field.get(cube.size) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 0);
                }
                if (i == 3)
                {
                    while (cube.sides.get(5).field.get(1) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 8);
                }
                if (i == 4)
                {
                    while (cube.sides.get(5).field.get(cube.size * 2 - 1) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 2);
                }
                //System.out.println("лево " + i);
                solve_cross(cube);
            }
            if (cube.sides.get(i).field.get(cube.size * 2 - 1) == color)
            {
                if (i == 0)
                {
                    while (cube.sides.get(5).field.get(cube.size * 2 - 1) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 2);
                    cube.oper((byte) 2);
                }
                if (i == 1)
                {
                    while (cube.sides.get(5).field.get(cube.size) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 9);
                }
                if (i == 2)
                {
                    while (cube.sides.get(5).field.get(cube.size * 2 - 1) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 3);
                }
                if (i == 3)
                {
                    while (cube.sides.get(5).field.get(cube.size * cube.size - 2) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 11);
                }
                if (i == 4)
                {
                    while (cube.sides.get(5).field.get(cube.size) == color)
                        cube.oper((byte) 6);
                    cube.oper((byte) 1);
                }
                //System.out.println("право " + i);
                solve_cross(cube);
            }
        }
    }

    public static void solve_full_cross(Cube cube)
    {
        if (cube.sides.get(5).field.get(1) == 0)
        {
            int side = 1;

            while (cube.sides.get(1 + side % 4).field.get(cube.size * cube.size - 2) != cube.sides.get(1 + side % 4).field.get(cube.size + 1))
            {cube.oper((byte) 6);side++;}

            do_oper(cube, side);

            solve_full_cross(cube);
            return ;
        }
        if (cube.sides.get(5).field.get(cube.size * 2 - 1) == 0)
        {
            int side = 2;

            while (cube.sides.get(1 + side % 4).field.get(cube.size * cube.size - 2) != cube.sides.get(1 + side % 4).field.get(cube.size + 1))
            {cube.oper((byte) 6);side++;}

            do_oper(cube, side);

            solve_full_cross(cube);
            return ;
        }
        if (cube.sides.get(5).field.get(cube.size) == 0)
        {
            int side = 0;

            while (cube.sides.get(1 + side % 4).field.get(cube.size * cube.size - 2) != cube.sides.get(1 + side % 4).field.get(cube.size + 1))
            {cube.oper((byte) 6);side++;}

            do_oper(cube, side);

            solve_full_cross(cube);
            return ;
        }
        if (cube.sides.get(5).field.get(cube.size * cube.size - 2) == 0)
        {
            int side = 3;

            while (cube.sides.get(1 + side % 4).field.get(cube.size * cube.size - 2) != cube.sides.get(1 + side % 4).field.get(cube.size + 1))
            {cube.oper((byte) 6);side++;}

            do_oper(cube, side);

            solve_full_cross(cube);
        }
    }

    public static void do_oper(Cube cube, int side)
    {
        switch (1 + side % 4)
        {
            case 1 :
            {
                cube.oper((byte) 0);
                cube.oper((byte) 0);
                break ;
            }
            case 2 :
            {
                cube.oper((byte) 8);
                cube.oper((byte) 8);
                break ;
            }
            case 3 :
            {
                cube.oper((byte) 2);
                cube.oper((byte) 2);
                break ;
            }
            case 4 :
            {
                cube.oper((byte) 10);
                cube.oper((byte) 10);
                break ;
            }
        }
    }

    public static void side_p(Cube cube)
    {
        byte s1 = cube.sides.get(1).field.get(cube.RD);
        byte s2 = cube.sides.get(2).field.get(cube.LD);
        byte s3 = cube.sides.get(5).field.get(cube.LU);
        if (s1 == 0 || s2 == 0 || s3 == 0)
        {
            int min = 0;
            if (s1 != 0)
                min = s1;

            if (s2 != 0 && (s2 < min || min == 0))
                min = s2;

            if (s3 != 0 && (s3 < min || min == 0))
                min = s3;

            if ((s1 == 4 ||
                    s2 == 4 ||
                    s3 == 4) && (s1 != 3 &&
                    s2 != 3 &&
                    s3 != 3))
                min = 4;

            if (min == 1) {
                while (!(cube.sides.get(0).field.get(cube.LD) == 0 &&
                cube.sides.get(1).field.get(cube.RU) == 1))
                    LDLD(cube, (byte) 2);
            }
            if (min == 2)
            {
                cube.oper((byte) 6);
                side_v(cube);
            }
            if (min == 3) {
                cube.oper((byte) 6);
                cube.oper((byte) 6);
                side_t(cube);
            }
            if (min == 4) {
                cube.oper((byte) 7);
                side_ch(cube);
            }
            solve_1_layer(cube);
        }
    }

    public static void side_v(Cube cube)
    {
        byte s1 = cube.sides.get(2).field.get(cube.RD);
        byte s2 = cube.sides.get(3).field.get(cube.LD);
        byte s3 = cube.sides.get(5).field.get(cube.RU);
        if (s1 == 0 || s2 == 0 || s3 == 0)
        {
            int min = 0;
            if (s1 != 0)
                min = s1;

            if (s2 != 0 && (s2 < min || min == 0))
                min = s2;

            if (s3 != 0 && (s3 < min || min == 0))
                min = s3;

            if ((s1 == 4 ||
                    s2 == 4 ||
                    s3 == 4) && (s1 != 3 &&
                    s2 != 3 &&
                    s3 != 3))
                min = 4;

            if (min == 2) {
                while (!(cube.sides.get(0).field.get(cube.RD) == 0 &&
                        cube.sides.get(2).field.get(cube.RU) == 2))
                    LDLD(cube, (byte) 3);
            }
            if (min == 3)
            {
                cube.oper((byte) 6);
                side_t(cube);
            }
            if (min == 4) {
                cube.oper((byte) 6);
                cube.oper((byte) 6);
                side_ch(cube);
            }
            if (min == 1) {
                cube.oper((byte) 7);
                side_p(cube);
            }
            solve_1_layer(cube);
        }
    }

    public static void side_t(Cube cube)
    {
        byte s1 = cube.sides.get(3).field.get(cube.RD);
        byte s2 = cube.sides.get(4).field.get(cube.LD);
        byte s3 = cube.sides.get(5).field.get(cube.RD);
        if (s1 == 0 || s2 == 0 || s3 == 0)
        {
            int min = 0;
            if (s1 != 0)
                min = s1;

            if (s2 != 0 && (s2 < min || min == 0))
                min = s2;

            if (s3 != 0 && (s3 < min || min == 0))
                min = s3;

            if ((s1 == 4 ||
                    s2 == 4 ||
                    s3 == 4) && (s1 != 3 &&
                    s2 != 3 &&
                    s3 != 3))
                min = 4;

            if (min == 3) {
                while (!(cube.sides.get(0).field.get(cube.RU) == 0 &&
                        cube.sides.get(3).field.get(cube.RU) == 3))
                    LDLD(cube, (byte) 4);
            }
            if (min == 4)
            {
                cube.oper((byte) 6);
                side_ch(cube);
            }
            if (min == 1) {
                cube.oper((byte) 6);
                cube.oper((byte) 6);
                side_p(cube);
            }
            if (min == 2) {
                cube.oper((byte) 7);
                side_v(cube);
            }
            solve_1_layer(cube);
        }
    }

    public static void side_ch(Cube cube)
    {
        byte s1 = cube.sides.get(4).field.get(cube.RD);
        byte s2 = cube.sides.get(1).field.get(cube.LD);
        byte s3 = cube.sides.get(5).field.get(cube.LD);
        if (s1 == 0 || s2 == 0 || s3 == 0)
        {
            int min = 0;
            if (s1 != 0)
                min = s1;

            if (s2 != 0 && (s2 < min || min == 0))
                min = s2;

            if (s3 != 0 && (s3 < min || min == 0))
                min = s3;

            if ((s1 == 4 ||
                    s2 == 4 ||
                    s3 == 4) && (s1 != 3 &&
                    s2 != 3 &&
                    s3 != 3))
                min = 4;

            if (min == 4) {
                while (!(cube.sides.get(0).field.get(cube.LU) == 0 &&
                        cube.sides.get(4).field.get(cube.RU) == 4))
                    LDLD(cube, (byte) 1);
            }
            if (min == 1)
            {
                cube.oper((byte) 6);
                side_p(cube);
            }
            if (min == 2) {
                cube.oper((byte) 6);
                cube.oper((byte) 6);
                side_v(cube);
            }
            if (min == 3) {
                cube.oper((byte) 7);
                side_t(cube);
            }
            solve_1_layer(cube);
        }
    }

    public static void solve_1_layer(Cube cube)
    {
        side_p(cube);
        side_v(cube);
        side_t(cube);
        side_ch(cube);
        if (kick_color(cube))
            solve_1_layer(cube);
    }

    public static boolean kick_color(Cube cube)
    {
        byte s1 = cube.sides.get(0).field.get(cube.LD);
        byte s2 = cube.sides.get(1).field.get(cube.RU);
        byte s3 = cube.sides.get(2).field.get(cube.LU);

        if ((s1 == 0 || s2 == 0 || s3 == 0) && s2 != cube.sides.get(1).field.get(cube.C))
        {
            LDLD(cube, (byte) 2);
            return true;
        }

        s1 = cube.sides.get(0).field.get(cube.RD);
        s2 = cube.sides.get(2).field.get(cube.RU);
        s3 = cube.sides.get(3).field.get(cube.LU);

        if ((s1 == 0 || s2 == 0 || s3 == 0) && s2 != cube.sides.get(2).field.get(cube.C))
            {LDLD(cube, (byte) 3);return true;}

        s1 = cube.sides.get(0).field.get(cube.RU);
        s2 = cube.sides.get(3).field.get(cube.RU);
        s3 = cube.sides.get(4).field.get(cube.LU);

        if ((s1 == 0 || s2 == 0 || s3 == 0) && s2 != cube.sides.get(3).field.get(cube.C))
            {LDLD(cube, (byte) 4);return true;}

        s1 = cube.sides.get(0).field.get(cube.LU);
        s2 = cube.sides.get(4).field.get(cube.RU);
        s3 = cube.sides.get(1).field.get(cube.LU);

        if ((s1 == 0 || s2 == 0 || s3 == 0) && s2 != cube.sides.get(4).field.get(cube.C))
            {LDLD(cube, (byte) 1);return true;}
        return false;
    }

    public static void solve_2_layer(Cube cube)
    {
        solve_2_layer_1(cube);
        solve_2_layer_2(cube);
        solve_2_layer_3(cube);
        solve_2_layer_4(cube);
    }

    public static void solve_2_layer_1(Cube cube)
    {
        if (cube.sides.get(1).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.L) != 5 && cube.sides.get(1).field.get(cube.D).equals(cube.sides.get(1).field.get(cube.C)))
        {
            if (cube.sides.get(5).field.get(cube.L).equals(cube.sides.get(2).field.get(cube.C)))
            {
                cube.oper((byte) 7);
                RDRD(cube, (byte) 1);
                LDLD(cube, (byte) 2);
            }
            else
            {
                cube.oper((byte) 6);
                LDLD(cube, (byte) 1);
                RDRD(cube, (byte) 4);
            }
            solve_2_layer_1(cube);
        }

        if (cube.sides.get(2).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.U) != 5 && cube.sides.get(2).field.get(cube.D).equals(cube.sides.get(2).field.get(cube.C)))
        {
            if (cube.sides.get(5).field.get(cube.U).equals(cube.sides.get(3).field.get(cube.C)))
            {
                cube.oper((byte) 7);
                RDRD(cube, (byte) 2);
                LDLD(cube, (byte) 3);
            }
            else
            {
                cube.oper((byte) 6);
                LDLD(cube, (byte) 2);
                RDRD(cube, (byte) 1);
            }
            solve_2_layer_1(cube);
        }

        if (cube.sides.get(3).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.R) != 5 && cube.sides.get(3).field.get(cube.D).equals(cube.sides.get(3).field.get(cube.C)))
        {
            if (cube.sides.get(5).field.get(cube.R).equals(cube.sides.get(4).field.get(cube.C)))
            {
                cube.oper((byte) 7);
                RDRD(cube, (byte) 3);
                LDLD(cube, (byte) 4);
            }
            else
            {
                cube.oper((byte) 6);
                LDLD(cube, (byte) 3);
                RDRD(cube, (byte) 2);
            }
            solve_2_layer_1(cube);
        }

        if (cube.sides.get(4).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.D) != 5 && cube.sides.get(4).field.get(cube.D).equals(cube.sides.get(4).field.get(cube.C)))
        {
            if (cube.sides.get(5).field.get(cube.D).equals(cube.sides.get(1).field.get(cube.C)))
            {
                cube.oper((byte) 7);
                RDRD(cube, (byte) 4);
                LDLD(cube, (byte) 1);
            }
            else
            {
                cube.oper((byte) 6);
                LDLD(cube, (byte) 4);
                RDRD(cube, (byte) 3);
            }
            solve_2_layer_1(cube);
        }
    }

    public static void solve_2_layer_2(Cube cube)
    {
        if (cube.sides.get(1).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.L) != 5)
        {
            if (cube.sides.get(1).field.get(cube.D).equals(cube.sides.get(2).field.get(cube.C)))
            {
                cube.oper((byte) 6);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                return ;
            }
            if (cube.sides.get(1).field.get(cube.D).equals(cube.sides.get(4).field.get(cube.C)))
            {
                cube.oper((byte) 7);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                return ;
            }
        }

        if (cube.sides.get(2).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.U) != 5)
        {
            if (cube.sides.get(2).field.get(cube.D).equals(cube.sides.get(3).field.get(cube.C)))
            {
                cube.oper((byte) 6);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                return ;
            }
            if (cube.sides.get(2).field.get(cube.D).equals(cube.sides.get(1).field.get(cube.C)))
            {
                cube.oper((byte) 7);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                return ;
            }
        }

        if (cube.sides.get(3).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.R) != 5)
        {
            if (cube.sides.get(3).field.get(cube.D).equals(cube.sides.get(4).field.get(cube.C)))
            {
                cube.oper((byte) 6);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                return ;
            }
            if (cube.sides.get(3).field.get(cube.D).equals(cube.sides.get(2).field.get(cube.C)))
            {
                cube.oper((byte) 7);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                return ;
            }
        }

        if (cube.sides.get(4).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.D) != 5)
        {
            if (cube.sides.get(4).field.get(cube.D).equals(cube.sides.get(1).field.get(cube.C)))
            {
                cube.oper((byte) 6);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                return ;
            }
            if (cube.sides.get(4).field.get(cube.D).equals(cube.sides.get(3).field.get(cube.C)))
            {
                cube.oper((byte) 7);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
            }
        }
    }

    public static void solve_2_layer_3(Cube cube)
    {
        if (cube.sides.get(1).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.L) != 5)
        {
            if (cube.sides.get(1).field.get(cube.D).equals(cube.sides.get(3).field.get(cube.C)))
            {
                cube.oper((byte) 6);
                cube.oper((byte) 6);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                solve_2_layer_3(cube);
                return ;
            }
        }

        if (cube.sides.get(2).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.U) != 5)
        {
            if (cube.sides.get(2).field.get(cube.D).equals(cube.sides.get(4).field.get(cube.C)))
            {
                cube.oper((byte) 6);
                cube.oper((byte) 6);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                solve_2_layer_3(cube);
                return ;
            }
        }

        if (cube.sides.get(3).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.R) != 5)
        {
            if (cube.sides.get(3).field.get(cube.D).equals(cube.sides.get(1).field.get(cube.C)))
            {
                cube.oper((byte) 6);
                cube.oper((byte) 6);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                solve_2_layer_3(cube);
                return ;
            }
        }

        if (cube.sides.get(4).field.get(cube.D) != 5 && cube.sides.get(5).field.get(cube.D) != 5)
        {
            if (cube.sides.get(4).field.get(cube.D).equals(cube.sides.get(1).field.get(cube.C)))
            {
                cube.oper((byte) 6);
                cube.oper((byte) 6);
                solve_2_layer_1(cube);
                solve_2_layer_2(cube);
                solve_2_layer_3(cube);
            }
        }
    }

    public static void solve_2_layer_4(Cube cube)
    {
        if (!cube.sides.get(1).field.get(cube.R).equals(cube.sides.get(1).field.get(cube.C)))
        {
            cube.oper((byte) 7);
            RDRD(cube, (byte) 1);
            LDLD(cube, (byte) 2);
            solve_2_layer_1(cube);
            solve_2_layer_2(cube);
            solve_2_layer_3(cube);
            solve_2_layer_4(cube);
            return ;
        }
        if (!cube.sides.get(1).field.get(cube.L).equals(cube.sides.get(1).field.get(cube.C)))
        {
            cube.oper((byte) 6);
            LDLD(cube, (byte) 1);
            RDRD(cube, (byte) 4);
            solve_2_layer_1(cube);
            solve_2_layer_2(cube);
            solve_2_layer_3(cube);
            solve_2_layer_4(cube);
            return ;
        }

        if (!cube.sides.get(2).field.get(cube.R).equals(cube.sides.get(2).field.get(cube.C)))
        {
            cube.oper((byte) 6);
            LDLD(cube, (byte) 3);
            RDRD(cube, (byte) 2);
            solve_2_layer_1(cube);
            solve_2_layer_2(cube);
            solve_2_layer_3(cube);
            solve_2_layer_4(cube);
            return ;
        }
        if (!cube.sides.get(2).field.get(cube.L).equals(cube.sides.get(2).field.get(cube.C)))
        {
            cube.oper((byte) 6);
            LDLD(cube, (byte) 2);
            RDRD(cube, (byte) 1);
            solve_2_layer_1(cube);
            solve_2_layer_2(cube);
            solve_2_layer_3(cube);
            solve_2_layer_4(cube);
            return ;
        }

        if (!cube.sides.get(3).field.get(cube.R).equals(cube.sides.get(3).field.get(cube.C)))
        {
            cube.oper((byte) 7);
            RDRD(cube, (byte) 3);
            LDLD(cube, (byte) 4);
            solve_2_layer_1(cube);
            solve_2_layer_2(cube);
            solve_2_layer_3(cube);
            solve_2_layer_4(cube);
            return ;
        }
        if (!cube.sides.get(3).field.get(cube.L).equals(cube.sides.get(3).field.get(cube.C)))
        {
            cube.oper((byte) 6);
            LDLD(cube, (byte) 3);
            RDRD(cube, (byte) 2);
            solve_2_layer_1(cube);
            solve_2_layer_2(cube);
            solve_2_layer_3(cube);
            solve_2_layer_4(cube);
            return ;
        }

        if (!cube.sides.get(4).field.get(cube.R).equals(cube.sides.get(4).field.get(cube.C)))
        {
            cube.oper((byte) 7);
            RDRD(cube, (byte) 4);
            LDLD(cube, (byte) 1);
            solve_2_layer_1(cube);
            solve_2_layer_2(cube);
            solve_2_layer_3(cube);
            solve_2_layer_4(cube);
            return ;
        }
        if (!cube.sides.get(4).field.get(cube.L).equals(cube.sides.get(4).field.get(cube.C)))
        {
            cube.oper((byte) 6);
            LDLD(cube, (byte) 4);
            RDRD(cube, (byte) 3);
            solve_2_layer_1(cube);
            solve_2_layer_2(cube);
            solve_2_layer_3(cube);
            solve_2_layer_4(cube);
        }
    }

    public static void solve_down_cross(Cube cube)
    {
        if (!down_cross_solved(cube))
            line_cross(cube);
        if (!down_cross_solved(cube))
            solve_angle(cube);
        if (!down_cross_solved(cube))
            solve_point(cube);
        if (!down_cross_solved(cube))
        {
            main.flag = false;
            System.out.println("stop");
        }
    }

    public static void solve_point(Cube cube)
    {
        cube.oper((byte) 10);
        LDLD(cube, (byte) 4);
        LDLD(cube, (byte) 4);
        cube.oper((byte) 11);
        line_cross(cube);
    }

    public static void solve_angle(Cube cube)
    {
        if (cube.sides.get(5).field.get(cube.L).equals(cube.sides.get(5).field.get(cube.U)))
        {
            cube.oper((byte) 10);
            LDLD(cube, (byte) 4);
            LDLD(cube, (byte) 4);
            cube.oper((byte) 11);
            return ;
        }
        if (cube.sides.get(5).field.get(cube.R).equals(cube.sides.get(5).field.get(cube.U)))
        {
            cube.oper((byte) 0);
            LDLD(cube, (byte) 1);
            LDLD(cube, (byte) 1);
            cube.oper((byte) 1);
            return ;
        }
        if (cube.sides.get(5).field.get(cube.R).equals(cube.sides.get(5).field.get(cube.D)))
        {
            cube.oper((byte) 8);
            LDLD(cube, (byte) 2);
            LDLD(cube, (byte) 2);
            cube.oper((byte) 9);
            return ;
        }
        if (cube.sides.get(5).field.get(cube.L).equals(cube.sides.get(5).field.get(cube.D)))
        {
            cube.oper((byte) 2);
            LDLD(cube, (byte) 3);
            LDLD(cube, (byte) 3);
            cube.oper((byte) 3);
        }
    }

    public static boolean down_cross_solved(Cube cube)
    {
        return cube.sides.get(5).field.get(cube.L).equals(cube.sides.get(5).field.get(cube.C)) &&
                cube.sides.get(5).field.get(cube.R).equals(cube.sides.get(5).field.get(cube.L)) &&
                cube.sides.get(5).field.get(cube.U).equals(cube.sides.get(5).field.get(cube.L));
    }

    public static void line_cross(Cube cube)
    {
        if (cube.sides.get(5).field.get(cube.L).equals(cube.sides.get(5).field.get(cube.C)) &&
                cube.sides.get(5).field.get(cube.R).equals(cube.sides.get(5).field.get(cube.L)))
        {
            cube.oper((byte) 10);
            LDLD(cube, (byte) 4);
            cube.oper((byte) 11);
            return ;
        }
        if (cube.sides.get(5).field.get(cube.U).equals(cube.sides.get(5).field.get(cube.C)) &&
                cube.sides.get(5).field.get(cube.D).equals(cube.sides.get(5).field.get(cube.U)))
        {
            cube.oper((byte) 0);
            LDLD(cube, (byte) 1);
            cube.oper((byte) 1);
        }
    }

    public static void right_angle_up(Cube cube)
    {
        boolean s1_2 = right_angle(cube, 1, 2, cube.LU);
        boolean s2_3 = right_angle(cube, 2, 3, cube.RU);
        boolean s3_4 = right_angle(cube, 3, 4, cube.RD);
        boolean s4_1 = right_angle(cube, 4, 1, cube.LD);

        int count = 0;

        if (s1_2)
            count++;
        if (s2_3)
            count++;
        if (s3_4)
            count++;
        if (s4_1)
            count++;

        if (count < 2)
        {
            cube.oper((byte) 6);
            right_angle_up(cube);
            return ;
        }
        if (s1_2 && s2_3 && count == 2)
        {
            for (int i = 0; i < 3; i++)
                LDLD(cube, (byte) 1);
            for (int i = 0; i < 3; i++)
                RDRD(cube, (byte) 4);
            right_angle_up(cube);
            return ;
        }
        if (s2_3 && s3_4 && count == 2)
        {
            for (int i = 0; i < 3; i++)
                LDLD(cube, (byte) 2);
            for (int i = 0; i < 3; i++)
                RDRD(cube, (byte) 1);
            right_angle_up(cube);
            return ;
        }
        if (s3_4 && s4_1 && count == 2)
        {
            for (int i = 0; i < 3; i++)
                LDLD(cube, (byte) 4);
            for (int i = 0; i < 3; i++)
                RDRD(cube, (byte) 3);
            right_angle_up(cube);
            return ;
        }
        if (s4_1 && s1_2 && count == 2)
        {
            for (int i = 0; i < 3; i++)
                LDLD(cube, (byte) 3);
            for (int i = 0; i < 3; i++)
                RDRD(cube, (byte) 2);
            right_angle_up(cube);
            return ;
        }
        if (count == 2)
        {
            for (int i = 0; i < 3; i++)
                LDLD(cube, (byte) 3);
            for (int i = 0; i < 3; i++)
                RDRD(cube, (byte) 2);
            right_angle_up(cube);
        }
    }

    public static boolean right_angle(Cube cube, int a, int b, int position)
    {
        return ((cube.sides.get(a).field.get(cube.RD) == cube.sides.get(a).field.get(cube.C) ||
                cube.sides.get(b).field.get(cube.LD) == cube.sides.get(a).field.get(cube.C) ||
                cube.sides.get(5).field.get(position) == cube.sides.get(a).field.get(cube.C)) &&
                (cube.sides.get(a).field.get(cube.RD) == cube.sides.get(b).field.get(cube.C) ||
                        cube.sides.get(b).field.get(cube.LD) == cube.sides.get(b).field.get(cube.C) ||
                        cube.sides.get(5).field.get(position) == cube.sides.get(b).field.get(cube.C)) &&
                (cube.sides.get(a).field.get(cube.RD) == cube.sides.get(5).field.get(cube.C) ||
                        cube.sides.get(b).field.get(cube.LD) == cube.sides.get(5).field.get(cube.C) ||
                        cube.sides.get(5).field.get(position) == cube.sides.get(5).field.get(cube.C)));
    }

    public static void solve_angle_up(Cube cube)
    {
        if (cube.sides.get(5).field.get(cube.LU) == 5 &&
                cube.sides.get(5).field.get(cube.LD) == 5 &&
                cube.sides.get(5).field.get(cube.RU) == 5 &&
                cube.sides.get(5).field.get(cube.RD) == 5)
            return ;
        while (!have_5(cube))
            cube.oper((byte) 7);

        while (cube.sides.get(5).field.get(cube.LU) != 5)
            LDLD_UP(cube, (byte) 1);

        solve_angle_up(cube);
    }

    public static boolean have_5(Cube cube)
    {
        return (cube.sides.get(1).field.get(cube.RD) == 5 ||
                cube.sides.get(2).field.get(cube.LD) == 5);
    }

    public static void finish_solve(Cube cube)
    {
        if (cube.is_solved())
            return ;

        int count = 0;

        if (line_is_solved(cube, (byte) 1))
            count++;
        if (line_is_solved(cube, (byte) 2))
            count++;
        if (line_is_solved(cube, (byte) 3))
            count++;
        if (line_is_solved(cube, (byte) 4))
            count++;

        if (count > 2)
        {
            while (!cube.is_solved())
                cube.oper((byte) 6);
            return ;
        }
        if (count == 1)
        {
            while (!line_is_solved(cube, (byte) 2))
                cube.oper((byte) 6);
            LDLD(cube, (byte) 2);
            RDRD(cube, (byte) 2);
            for (int i = 0; i < 5; i++)
                LDLD(cube, (byte) 2);
            for (int i = 0; i < 5; i++)
                RDRD(cube, (byte) 2);
            finish_solve(cube);
        }
        else
        {
            LDLD(cube, (byte) 2);
            RDRD(cube, (byte) 2);
            for (int i = 0; i < 5; i++)
                LDLD(cube, (byte) 2);
            for (int i = 0; i < 5; i++)
                RDRD(cube, (byte) 2);
            finish_solve(cube);
        }
    }

    public static boolean line_is_solved(Cube cube, byte side)
    {
        return (cube.sides.get(side).field.get(cube.LD) == cube.sides.get(side).field.get(cube.D) &&
                cube.sides.get(side).field.get(cube.LD) == cube.sides.get(side).field.get(cube.RD));
    }

    public static void LDLD_UP(Cube cube, byte side)
    {
        switch (side) {
            case 1: {
                cube.oper((byte) 8);
                cube.oper((byte) 4);
                cube.oper((byte) 9);
                cube.oper((byte) 5);
                break;
            }
            case 2: {
                cube.oper((byte) 2);
                cube.oper((byte) 4);
                cube.oper((byte) 3);
                cube.oper((byte) 5);
                break;
            }
            case 3: {
                cube.oper((byte) 10);
                cube.oper((byte) 4);
                cube.oper((byte) 11);
                cube.oper((byte) 5);
                break;
            }
            case 4: {
                cube.oper((byte) 0);
                cube.oper((byte) 4);
                cube.oper((byte) 1);
                cube.oper((byte) 5);
                break;
            }
        }
    }

    public static void LDLD(Cube cube, byte side)
    {
        switch (side) {
            case 1: {
                cube.oper((byte) 10);
                cube.oper((byte) 6);
                cube.oper((byte) 11);
                cube.oper((byte) 7);
                break;
            }
            case 2: {
                cube.oper((byte) 0);
                cube.oper((byte) 6);
                cube.oper((byte) 1);
                cube.oper((byte) 7);
                break;
            }
            case 3: {
                cube.oper((byte) 8);
                cube.oper((byte) 6);
                cube.oper((byte) 9);
                cube.oper((byte) 7);
                break;
            }
            case 4: {
                cube.oper((byte) 2);
                cube.oper((byte) 6);
                cube.oper((byte) 3);
                cube.oper((byte) 7);
                break;
            }
        }
    }

    public static void RDRD(Cube cube, byte side)
    {
        switch (side) {
            case 1: {
                cube.oper((byte) 9);
                cube.oper((byte) 7);
                cube.oper((byte) 8);
                cube.oper((byte) 6);
                break;
            }
            case 2: {
                cube.oper((byte) 3);
                cube.oper((byte) 7);
                cube.oper((byte) 2);
                cube.oper((byte) 6);
                break;
            }
            case 3: {
                cube.oper((byte) 11);
                cube.oper((byte) 7);
                cube.oper((byte) 10);
                cube.oper((byte) 6);
                break;
            }
            case 4: {
                cube.oper((byte) 1);
                cube.oper((byte) 7);
                cube.oper((byte) 0);
                cube.oper((byte) 6);
                break;
            }
        }
    }
}
