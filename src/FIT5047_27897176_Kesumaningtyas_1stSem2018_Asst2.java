import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.sin;

public class FIT5047_27897176_Kesumaningtyas_1stSem2018_Asst2 {
    public static void main(String[] args)
    {
         //question2A(.95909);
         //question2B();
         //question2C();
         //question2D();
        menu();
    }

    public static void menu()
    {
        int option;
        do{
            printMenu();
            Scanner console = new Scanner(System.in);

            while(true)
            {
                if (console.hasNextInt())
                {
                    option = console.nextInt();
                    break;
                }
                else
                    console.nextLine();
                System.out.println();
                System.out.println("\n\tERROR : Invalid Input. Please enter a valid number 1 - 5 ");
                System.out.println();
                printMenu();
            }

            switch (option)
            {
                case 1:
                    get2A();break;

                case 2:
                    get2B();break;

                case 3:
                    get2C();break;

                case 4:
                    get2D();break;

                case 5:
                    exit();break;

                default:
                    System.out.println("\n\tERROR : Invalid Input. Please enter a valid number 1 - 5 \n ");
            }


        }while(true);
    }

    //METHOD FOR QUESTION 2A-------------------------------------------
    public static void question2A(double input_u){
        double temp = 10000.0;
        DecimalFormat format = new DecimalFormat("##.00000");
        double deltaResult;
        double cand_z;
        double random_u;
        double curr_z;
        double u;
        double u_max = 0;
        double minTemp = 1;
        double max = -1;
        double temp_max = -1;
        double threshold = rand();
        Random random = new Random();

        //user specified value of u
        u = input_u;

        //we get first value for z
        curr_z =  u * sin(1/(0.01 + (u*u))) + (u*u*u) * sin(1/(0.001 + (u*u*u*u)));
        //System.out.println("MAX2A :" + curr_z);

        do{
            random_u = -1 + (1 - (-1)) * random.nextDouble();
            cand_z =  random_u * sin(1/(0.01 + (random_u*random_u))) + (random_u*random_u*random_u) * sin(1/(0.001
                    + (random_u*random_u*random_u*random_u)));

            deltaResult = cand_z - curr_z;

            if(deltaResult > 0)
            {
                curr_z = cand_z;
                u = random_u;
            }
            else
            if(rand() <= Math.exp(deltaResult/temp))
            {
                curr_z = cand_z;
                u = random_u;
            }

            if(curr_z > max)
            {
                max = curr_z;
                temp_max = temp;
                u_max = u;
            }

            System.out.println("PROCESSING-- " + "Temp :" + format.format(temp) + " z :" + format.format(curr_z) + " u: " + format.format(u));
            temp = 0.99998 * temp; //should pick random temp?

        }while(minTemp < temp || curr_z >= threshold);



        System.out.println("FINAL-- "+ "z Max: " + format.format(max) + " || Temp: " + format.format(temp_max) + " ||u :" + format.format(u_max));


    }

    //METHOD FOR QUESTION 2B-----------------------------------------------
    public static void question2B(double input_u, double input_v){
        double temp = 10000.0;
        DecimalFormat format = new DecimalFormat("##.00000");
        double deltaResult;
        double cand_z;
        double random_u;
        double random_v;
        double curr_z;
        double u ;
        double v;
        double u_max = 0;
        double v_max = 0;
        double minTemp = 1;
        double max = -1;
        double temp_max = -1;
        double threshold = rand();
        Random random = new Random();


        u = input_u;
        v = input_v;
        curr_z  = u * v * v *sin(v/(0.01 + (u*u) ))+ u*u*u*v*v * sin(v*v*v/(0.001 + (u*u*u*u)));
        //System.out.println("MAX2B :" + curr_z);

        do{
            random_u = -1 + (1 - (-1)) * random.nextDouble();
            random_v = -1 + (1 - (-1)) * random.nextDouble();

            cand_z =  random_u * random_v *random_v  * sin(random_v /(0.01 + (random_u*random_u)))
                    + random_u*random_u*random_u*random_v*random_v * sin(random_v *random_v *random_v /(0.001
                    + (random_u*random_u*random_u*random_u)));

            deltaResult = cand_z - curr_z;

            if(deltaResult > 0)
            {
                curr_z = cand_z;
                u = random_u;
                v = random_v;
            }
            else
            if(rand() <= Math.exp(deltaResult/temp))
            {
                curr_z = cand_z;
                u = random_u;
                v = random_v;
            }

            if(curr_z > max)
            {
                max = curr_z;
                temp_max = temp;
                u_max = u;
                v_max = v;
            }

            System.out.println("PROCESSING-- " + "Temp :" + format.format(temp) + " z :" + format.format(curr_z) + " u: " + format.format(u)+ " v: " + format.format(v));
            temp = 0.99998 * temp; //should pick random temp?

        }while(minTemp < temp || curr_z >= threshold);


        System.out.println("FINAL-- "+ "z Max: " + format.format(max) + " || Temp: " + format.format(temp_max) + " ||u :" + format.format(u_max) + " ||v :" + format.format(v_max));

    }

    //METHOD FOR QUESTION 2C-----------------------------------------------
    public static void question2C(double input_u, double input_v, double input_w){
        double temp = 10000.0;
        DecimalFormat format = new DecimalFormat("##.00000");
        double deltaResult;
        double cand_z;
        double random_u;
        double random_v;
        double curr_z;
        double u ;
        double v;
        double u_max = 0;
        double v_max = 0;
        double minTemp = 1;
        double max = -1;
        double temp_max = -1;
        double threshold = rand();
        Random random = new Random();


        double random_w;
        double w_max = -1;

        double w = input_w;
        u = input_u;
        v = input_v;

        curr_z = (u*v*v + sin( Math.PI * w)) *
                sin(v/(0.01 + (u*u))) *
                sin(Math.PI * w/2) +
                u*u*u*v*v*w *
                        sin(v*v*v/(0.001 * (sin(Math.PI * w/2)* sin(Math.PI * w/2)) + u*u*u*u + (w-1)*(w-1)));
        // System.out.println("MAX2C :" + curr_z);

        do{
            random_u = -1 + (1 - (-1)) * random.nextDouble();
            random_v = -1 + (1 - (-1)) * random.nextDouble();
            random_w = -1 + (1 - (-1)) * random.nextDouble();


            cand_z =  (random_u*random_v*random_v +
                    sin( Math.PI * random_w ))*
                    sin(random_v/(0.01 + (random_u*random_u))) *
                    sin(Math.PI * random_w /2) +
                    random_u*random_u*random_u*random_v*random_v*random_w  *
                            sin(random_v*random_v*random_v/(0.001 * (sin(Math.PI * random_w /2)*sin(Math.PI * random_w /2))
                                    + random_u*random_u*random_u*random_u + (random_w -1)*(random_w -1)));

            deltaResult = cand_z - curr_z;

            if(deltaResult > 0)
            {
                curr_z = cand_z;
                u = random_u;
                v = random_v;
                w = random_w;
            }
            else
            if(rand() <= Math.exp(deltaResult/temp))
            {
                curr_z = cand_z;
                u = random_u;
                v = random_v;
                w = random_w;
            }

            if(curr_z > max)
            {
                max = curr_z;
                temp_max = temp;
                u_max = u;
                v_max = v;
                w_max = w;
            }

            System.out.println("PROCESSING-- " +
                    "Temp :" + format.format(temp) +
                    " z :" + format.format(curr_z) +
                    " u: " + format.format(u)+
                    " v: " + format.format(v) +
                    " w: " + format.format(w));

            temp = 0.99998 * temp; //should pick random temp?

        }while(minTemp < temp || curr_z >= threshold);


        System.out.println("FINAL-- "+ "z Max: " + format.format(max) +
                " || Temp: " + format.format(temp_max) +
                " ||u :" + format.format(u_max) +
                " ||v :" + format.format(v_max) +
                " ||w :" + format.format(w_max));
    }

    //METHOD FOR QUESTION 2D-----------------------------------------------
    public static void question2D(double input_u, double input_v, double input_w, int input_y)
    {
        double temp = 10000.0;
        DecimalFormat format = new DecimalFormat("##.00000");
        double deltaResult;
        double cand_z;
        double random_u;
        double random_v;
        double curr_z;
        double u ;
        double v;
        double u_max = 0;
        double v_max = 0;
        double minTemp = 1;
        double max = -1;
        double temp_max = -1;
        double threshold = rand();
        Random random = new Random();


        int yMin = -1;
        int yMax = 1;
        int random_y;
        double random_w;
        double w_max = -1;
        double y_max = -1;

        int y = input_y;
        double w = input_w;
        u = input_u;
        v = input_v;

        curr_z = ((u*v*v + sin( Math.PI * w)) *
                sin(v/(0.01 + (u*u))) *
                sin(Math.PI * w/2) +
                u*u*u*v*v*w *
                        sin(v*v*v/(0.001 * (sin(Math.PI * w/2)* sin(Math.PI * w/2)) + u*u*u*u + (w-1)*(w-1)))) * y;
        System.out.println("MAX2D :" + curr_z);

        do{
            random_u = -1 + (1 - (-1)) * random.nextDouble();
            random_v = -1 + (1 - (-1)) * random.nextDouble();
            random_w = -1 + (1 - (-1)) * random.nextDouble();
            random_y = random.nextInt((yMax - yMin) + 1) + yMin;


            cand_z =  ((random_u*random_v*random_v +
                    sin( Math.PI * random_w ))*
                    sin(random_v/(0.01 + (random_u*random_u))) *
                    sin(Math.PI * random_w /2) +
                    random_u*random_u*random_u*random_v*random_v*random_w  *
                            sin(random_v*random_v*random_v/(0.001 * (sin(Math.PI * random_w /2)*sin(Math.PI * random_w /2))
                                    + random_u*random_u*random_u*random_u + (random_w -1)*(random_w -1)))) * random_y;

            deltaResult = cand_z - curr_z;

            if(deltaResult > 0)
            {
                curr_z = cand_z;
                u = random_u;
                v = random_v;
                w = random_w;
                y = random_y;
            }
            else
            if(rand() <= Math.exp(deltaResult/temp))
            {
                curr_z = cand_z;
                u = random_u;
                v = random_v;
                w = random_w;
                y = random_y;

            }

            if(curr_z > max)
            {
                max = curr_z;
                temp_max = temp;
                u_max = u;
                v_max = v;
                w_max = w;
                y_max = y;
            }

            System.out.println("PROCESSING-- " +
                    "Temp :" + format.format(temp) +
                    "   |z :" + format.format(curr_z) +
                    "   |u: " + format.format(u)+
                    "   |v: " + format.format(v) +
                    "   |w: " + format.format(w) +
                    "   |y: " + format.format(y)
            );

            temp = 0.99998 * temp; //should pick random temp?

        }while(minTemp < temp || curr_z >= threshold);

        System.out.println("FINAL-- "+ "z Max: " + format.format(max) +
                " || Temp: " + format.format(temp_max) +
                " ||u :" + format.format(u_max) +
                " ||v :" + format.format(v_max) +
                " ||w :" + format.format(w_max) +
                " ||y :" + format.format(y_max)
        );

    }



    //ASK USER FOR INPUT U FOR 2A
    public static void get2A()
    {
        Scanner console = new Scanner(System.in);
        String answer = "";
        boolean valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input any random(include decimal) value for U from -1<= U <= 1 (e.g. 0.5) :");
            answer = console.nextLine().trim();
            valid = answerValidation(answer, -1, 1);
        }

         double u_input = Double.parseDouble(answer);
        question2A(u_input);
    }


    //ASK USER FOR INPUT U,V FOR 2B
    public static void get2B()
    {
        Scanner console = new Scanner(System.in);
        String answer_u = "";
        String answer_v = "";
        boolean valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input any random(include decimal) value for U from -1<= U <= 1 (e.g. 0.5) :");
            answer_u = console.nextLine().trim();
            valid = answerValidation(answer_u, -1, 1);
        }

        valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input any random(include decimal) value for V from -1<= V <= 1 (e.g. 0.5) :");
            answer_v = console.nextLine().trim();
            valid = answerValidation(answer_v, -1, 1);
        }

        double u_input = Double.parseDouble(answer_u);
        double v_input = Double.parseDouble(answer_v);

        question2B(u_input,v_input);
    }

    //ASK USER FOR INPUT U,V,W FOR 2C
    public static void get2C()
    {
        Scanner console = new Scanner(System.in);
        String answer_u = "";
        String answer_v = "";
        String answer_w = "";
        boolean valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input any random(include decimal) value for U from -1<= U <= 1 (e.g. 0.5) :");
            answer_u = console.nextLine().trim();
            valid = answerValidation(answer_u, -1, 1);
        }

        valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input any random(include decimal) value for V from -1<= V <= 1 (e.g. 0.5) :");
            answer_v = console.nextLine().trim();
            valid = answerValidation(answer_v, -1, 1);
        }

        valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input any random(include decimal) value for W from -1<= W <= 1 (e.g. 0.5) :");
            answer_w = console.nextLine().trim();
            valid = answerValidation(answer_w, -1, 1);
        }

        double u_input = Double.parseDouble(answer_u);
        double v_input = Double.parseDouble(answer_v);
        double w_input = Double.parseDouble(answer_w);

        question2C(u_input,v_input,w_input);

    }

    //ASK USER FOR INPUT U,V,W,Y FOR 2D
    public static void get2D()
    {
        Scanner console = new Scanner(System.in);
        String answer_u = "";
        String answer_v = "";
        String answer_w = "";
        String answer_y = "";
        boolean valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input any random(include decimal) value for U from -1<= U <= 1 (e.g. 0.5) :");
            answer_u = console.nextLine().trim();
            valid = answerValidation(answer_u, -1, 1);
        }

        valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input any random(include decimal) value for V from -1<= V <= 1 (e.g. 0.5) :");
            answer_v = console.nextLine().trim();
            valid = answerValidation(answer_v, -1, 1);
        }

        valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input any random(include decimal) value for W from -1<= W <= 1 (e.g. 0.5) :");
            answer_w = console.nextLine().trim();
            valid = answerValidation(answer_w, -1, 1);
        }

        valid = false;

        while(!valid)
        {
            System.out.print("\n\t Please input value for Y (-1 or 0 or 1) :");
            answer_y = console.nextLine().trim();
            valid = intValidation(answer_y, -1, 1);
        }


        double u_input = Double.parseDouble(answer_u);
        double v_input = Double.parseDouble(answer_v);
        double w_input = Double.parseDouble(answer_w);
        int y_input = Integer.parseInt(answer_y);

        question2D(u_input,v_input,w_input,y_input);
    }

    //EXIT FROM SIMULATION
    public static void exit()
    {
        String reply = "";
        Scanner console = new Scanner(System.in);

        do
        {
            boolean valid = false;
            while (!valid)
            {
                System.out.print("\n\tAre you sure want to exit the simulation?(y/n) ");
                reply = console.nextLine().trim().toLowerCase();
                valid = checkNoBlank(reply);
            }
            reply = reply.substring(0, 1);
            if (reply.equals("y")) {
                System.out.println("\t------** Thankyou **------");
                System.exit(0);
            }
            else
            if (reply.equals("n"))
                return;
            else
                System.out.println("\n\tPlease enter your answer again (y/n) ");
        }while (!reply.equals("n") && !reply.equals("y"));
    }

    public static void printMenu()
    {
        System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("||                                                          WELCOME TO SIMULATED ANNEALING                                                     ||");
        System.out.println("=================================================================================================================================================");
        System.out.println("|\t(1) z = f(u) = u sin(1/(0.01 + u^2" + ")) + u^3 sin(1/(0.001 + u^4" + "))                                                                             |" +
                "\n|\t(2) z = f(u,v) = uv^2 sin(v/(0.01 + u^2" + ")) + u^3" + "v^2 sin(v^3" + "/(0.001 + u^4" + "))                                                                   |" +
                "\n|\t(3) z = f(u,v,w) = (uv^2 + sin(πw)) sin(v/(0.01 + u^2" + ")) sin(πw/2) + u^3" + "v^2" + "w sin(v^3" + "/(0.001 sin^2" + "(πw/2) + u^4 + (w-1)^2" + "))                    |" +
                "\n|\t(4) z = f(u,v,w,y) = ((uv^2 + sin(πw)) sin(v/(0.01 + u^2" + ")) sin(πw/2) + u^3" + "v^2" + "w sin(v^3" + "/(0.001 sin^2" + "(πw/2) + u^4 + (w-1)^2" + ")))y               |" +
                "\n|\t(5) Exit                                                                                                                                    |");
        System.out.println("=================================================================================================================================================");
        System.out.print("Please choose the number you want to find the optimum value (z) : ");
    }

    //VALIDATION FOR BLANK INPUT
    public static boolean checkNoBlank(String word)
    {
        boolean value = true;

        if (word.length() > 0)
            value = true;
        else
        if (word.length() == 0)
        {
            System.out.println();
            System.out.println("\t\t!!ERROR : Invalid Input. Please do not enter a blank space");
            System.out.println();
            value = false;
        }

        return value;
    }

    //VALIDATION FOR DECIMAL INPUT FROM -1 TO 1
    public static boolean answerValidation(String input, double min, double max)
    {
        Scanner console = new Scanner(input);
        boolean value = false;
        double numberToCheck;

        if (console.hasNextDouble())
        {
            numberToCheck = Double.parseDouble(input);
            if (numberToCheck <= max && numberToCheck >= min)
                value = true;
            else
            {
                System.out.println();
                System.out.print("\t\t!!ERROR : Invalid Input.Please enter a valid number (" + min + " - " + max +")");
                System.out.println();
                value = false;
            }
        }
        else
        {
            System.out.println();
            System.out.print("\t\t!!ERROR : Invalid Input.Please enter a valid number (" + min + " - " + max +")");
            System.out.println();
            value = false;
        }

        return value;
    }

    //VALIDATION FOR Y INPUT {-1,0,1}
    public static boolean intValidation(String input, int min, int max)
    {
        Scanner console = new Scanner(input);
        boolean value = false;
        double numberToCheck;

        if (console.hasNextInt())
        {
            numberToCheck = Integer.parseInt(input);
            if (numberToCheck <= max && numberToCheck >= min)
                value = true;
            else
            {
                System.out.print("\n\t\t!!ERROR : Invalid Input.Please enter a valid number (" + min + " - " + max +")");
                System.out.println();
                value = false;
            }
        }
        else
        {
            System.out.println();
            System.out.print("\t\t!!ERROR : Invalid Input.Please enter a valid number (" + min + " - " + max +")");
            System.out.println();
            value = false;
        }

        return value;
    }

    //GENERATE RANDOM VALUE
    public static double rand(){
        double randMax = 1;
        double randMin = 0;

        double diff = randMax - randMin;
        double randVal = randMin + Math.random() * diff;

        return randVal;
    }

}
