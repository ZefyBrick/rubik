import java.util.ArrayList;

public class Operations
{
    //L
    public static void L_(Cube cube)
    {
        L_(cube, 0);
    }

    public static void L_(Cube cube, int degree)
    {
        byte buf;

        if (degree < 0 || degree >= cube.size)
            return ;

        for (int i = 0; i < cube.size; i++)
        {
            buf = cube.sides.get(0).field.get(i * cube.size + degree);

            cube.sides.get(0).field.set(i * cube.size + degree, cube.sides.get(2).field.get(i * cube.size + degree));
            cube.sides.get(2).field.set(i * cube.size + degree, cube.sides.get(5).field.get(i * cube.size + degree));
            cube.sides.get(5).field.set(i * cube.size + degree, cube.sides.get(4).field.get((cube.size - 1 - i) * cube.size - 1 - degree + cube.size));
            cube.sides.get(4).field.set((cube.size - 1 - i) * cube.size - 1 - degree + cube.size, buf);
        }

        if (degree == 0)
            rotate(cube, (byte)1, true);
        if (degree == cube.size - 1)
            rotate(cube, (byte)3, false);
    }

    public static void L(Cube cube)
    {
        L(cube, 0);
    }

    public static void L(Cube cube, int degree)
    {
        L_(cube, degree);
        L_(cube, degree);
        L_(cube, degree);
    }
    //

    //R
    public static void R(Cube cube)
    {
        R(cube, 0);
    }

    public static void R(Cube cube, int degree)
    {
        L_(cube, cube.size - 1 - degree);
    }

    public static void R_(Cube cube)
    {
        R_(cube, 0);
    }

    public static void R_(Cube cube, int degree)
    {
        L(cube, cube.size - 1 - degree);
    }
    //

    //U
    public static void U(Cube cube)
    {
        U(cube, 0);
    }

    public static void U(Cube cube, int degree)
    {
        byte buf;

        if (degree < 0 || degree >= cube.size)
            return ;

        for (int i = 0; i < cube.size; i++)
        {
            buf = cube.sides.get(1).field.get(i + cube.size * degree);

            cube.sides.get(1).field.set(i + cube.size * degree, cube.sides.get(2).field.get(i + cube.size * degree));
            cube.sides.get(2).field.set(i + cube.size * degree, cube.sides.get(3).field.get(i + cube.size * degree));
            cube.sides.get(3).field.set(i + cube.size * degree, cube.sides.get(4).field.get(i + cube.size * degree));
            cube.sides.get(4).field.set(i + cube.size * degree, buf);
        }

        if (degree == 0)
            rotate(cube, (byte)0, false);
        if (degree == cube.size - 1)
            rotate(cube, (byte)5, true);
    }

    public static void U_(Cube cube)
    {
        U_(cube, 0);
    }

    public static void U_(Cube cube, int degree)
    {
        U(cube, degree);
        U(cube, degree);
        U(cube, degree);
    }
    //

    //D
    public static void D(Cube cube)
    {
        D(cube, 0);
    }

    public static void D(Cube cube, int degree)
    {
        U_(cube, cube.size - 1 - degree);
    }

    public static void D_(Cube cube)
    {
        D_(cube, 0);
    }

    public static void D_(Cube cube, int degree)
    {
        U(cube, cube.size - 1 - degree);
    }
    //

    //F
    public static void F(Cube cube)
    {
        F(cube, 0);
    }

    public static void F(Cube cube, int degree)
    {
        byte buf;

        if (degree < 0 || degree >= cube.size)
            return ;

        for (int i = 0; i < cube.size; i++)
        {
            buf = cube.sides.get(0).field.get(i + cube.size * (cube.size - 1 - degree));

            cube.sides.get(0).field.set(i + cube.size * (cube.size - 1 - degree), cube.sides.get(1).field.get((cube.size - 1 - i) * cube.size - 1 - degree + cube.size));
            cube.sides.get(1).field.set((cube.size - 1 - i) * cube.size - 1 - degree + cube.size, cube.sides.get(5).field.get((cube.size - 1 - i) + cube.size * degree));
            cube.sides.get(5).field.set((cube.size - 1 - i) + cube.size * degree, cube.sides.get(3).field.get(i * cube.size + degree));
            cube.sides.get(3).field.set(i * cube.size + degree, buf);
        }

        if (degree == 0)
            rotate(cube, (byte)2, false);
        if (degree == cube.size - 1)
            rotate(cube, (byte)4, true);
    }

    public static void F_(Cube cube)
    {
        F_(cube, 0);
    }

    public static void F_(Cube cube, int degree)
    {
        F(cube, degree);
        F(cube, degree);
        F(cube, degree);
    }
    //

    //B
    public static void B(Cube cube)
    {
        B(cube, 0);
    }

    public static void B(Cube cube, int degree)
    {
        F_(cube, cube.size - 1 - degree);
    }

    public static void B_(Cube cube)
    {
        B_(cube, 0);
    }

    public static void B_(Cube cube, int degree)
    {
        F(cube, cube.size - 1 - degree);
    }
    //

    public static void rotate(Cube cube, byte position, boolean counterclockwise) // против часовой = true
    {
        ArrayList<Byte> buf_array = new ArrayList<>();
        ini_aray(buf_array, (int) Math.pow(cube.size, 2));

        for (int i = 0; i < cube.size; i++)
        {
            for (int j = 0; j < cube.size; j++)
            {
                if (counterclockwise)
                    buf_array.set(i * cube.size + j, cube.sides.get(position).field.get(j * cube.size + (cube.size - 1 - i)));
                else
                    buf_array.set(j * cube.size + (cube.size - 1 - i), cube.sides.get(position).field.get(i * cube.size + j));
            }
        }

        cube.sides.get(position).field = buf_array;
    }

    public static void ini_aray(ArrayList<Byte> array, int size)
    {
        for (int i = 0; i < size; i++)
            array.add((byte) 0);
    }
}
