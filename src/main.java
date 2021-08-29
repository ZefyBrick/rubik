import java.io.*;
import java.util.Date;

public class main
{
    public static boolean flag = true;
    public static boolean random = false;

    public static void main(String args[])
    {
        Date d1 = new Date();
        if (!start())
            return ;
        Date d2 = new Date();
        System.out.println("Time: " + (d2.getTime() - d1.getTime()) + "\nTurns: " + Cube.count);
    }

    public static boolean start(){
        Cube cube = new Cube(3);

        int count = 0;
        while (flag)
        {
            if (!break_cube_file(cube) && !random)
                return false;
            File file = new File("solve");
            if (!file.exists())
            {
                try
                {
                    file.createNewFile();
                } catch (Exception ex){
                    System.out.println("The solve file could not be created");
                    return false;
                }
            }
            else
            {
                try {
                    FileWriter fstream1 = new FileWriter(file.getPath());
                    BufferedWriter out1 = new BufferedWriter(fstream1);
                    out1.write("");
                    out1.close();
                    if (random)
                    {
                        fstream1 = new FileWriter(new File("commands").getPath());
                        out1 = new BufferedWriter(fstream1);
                        out1.write("");
                        out1.close();
                    }
                } catch (Exception e)
                {
                    System.out.println("Failed to clear the solve file");
                    return false;
                }
            }
            if (random)
                break_cube(cube);
            cube.show_cube();
            Solve_3.solve(cube);
            cube.show_cube();
            if (++count >= 1)
                flag = false;
        }
        return true;
    }

    public static void break_cube(Cube cube)
    {
        for (int i = 0; i < 30; i++)
        {
            cube.oper((byte) (Math.random() * 12), new File("commands"));
        }
        Cube.count -= 30;
    }

    public static boolean break_cube_file(Cube cube)
    {
        BufferedReader objReader = null;
        try {
            String str;

            File file = new File("commands");

            if (!file.exists())
            {
                System.out.println("The commands file does not exist");
                return false;
            }

            objReader = new BufferedReader(new FileReader("commands"));

            while ((str = objReader.readLine()) != null)
            {
                if (str.equals("random"))
                {
                    random = true;
                    return true;
                }


                String[] strs = str.split("");

                int i = 1;

                if (str.split(" ").length == 2)
                    i = Integer.parseInt(str.split(" ")[1]);

                if (i < 1 || i > 10)
                {
                    System.out.println("The numeric argument can be = [1; 10]");
                    return false;
                }

                switch (strs[0].toUpperCase())
                {
                    case "L" :
                    {
                        while (i-- != 0)
                        {
                            if (strs.length > 1 && strs[1].equals("_"))
                                cube.oper((byte)1);
                            else
                                cube.oper((byte)0);
                        }
                        break ;
                    }
                    case "R" :
                    {
                        while (i-- != 0)
                        {
                            if (strs.length > 1 && strs[1].equals("_"))
                                cube.oper((byte)3);
                            else
                                cube.oper((byte)2);
                        }
                        break ;
                    }
                    case "U" :
                    {
                        while (i-- != 0)
                        {
                            if (strs.length > 1 && strs[1].equals("_"))
                                cube.oper((byte)5);
                            else
                                cube.oper((byte)4);
                        }
                        break ;
                    }
                    case "D" :
                    {
                        while (i-- != 0)
                        {
                            if (strs.length > 1 && strs[1].equals("_"))
                                cube.oper((byte)7);
                            else
                                cube.oper((byte)6);
                        }
                        break ;
                    }
                    case "F" :
                    {
                        while (i-- != 0)
                        {
                            if (strs.length > 1 && strs[1].equals("_"))
                                cube.oper((byte)9);
                            else
                                cube.oper((byte)8);
                        }
                        break ;
                    }
                    case "B" :
                    {
                        while (i-- != 0)
                        {
                            if (strs.length > 1 && strs[1].equals("_"))
                                cube.oper((byte)11);
                            else
                                cube.oper((byte)10);
                        }
                        break ;
                    }
                        /*" 0 - L,  1 - L',  2 - R,  3 - R'\n
                            4 - U,  5 - U',  6 - D,  7 - D'\n
                            8 - F,  9 - F', 10 - B, 11 - B'"*/
                }
            }
        } catch (Exception e)
        {
            System.out.println("The command file is not valid");
            return false;
        }
        return true;
    }

    public static boolean addStr(String str, File file)
    {
        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(file, true));
            out.write(str + " 1" + "\n");
            out.close();
        }

        catch (IOException e)
        {
            System.out.println("Failed to save rotation");
            return false;
        }
        return true;
    }
}
