import java.text.DecimalFormat;
import java.util.Random;
import static java.lang.Math.sin;


public class AnnealingSimulation {
	 public static void main(String[] args)
	    {
	        double temp = 400.0;
	        DecimalFormat format = new DecimalFormat("##.00000");
	        double deltaTemp;
	        double deltaResult;
	        double cand_u;
	        double random_u;
	        double curr_u;
	        double u = 0;
	        double minTemp = 1;
	        double current;
	        double max = -1;
	        double threshold = rand();
	        Random random = new Random();

	        curr_u =  u * sin(1/(0.01 + (u*u))) + (u*u*u) * sin(1/(0.001 + (u*u*u*u)));
	        System.out.println("REAL MAXO: "+curr_u);
	        System.out.println("LLLLLLLLLLLLLLLLLLL");

	        do{
	            random_u = -1 + (1 - (-1)) * random.nextDouble();
	            cand_u =  random_u * sin(1/(0.01 + (random_u*random_u))) + (random_u*random_u*random_u) * sin(1/(0.001 + (random_u*random_u*random_u*random_u)));

	            deltaResult = cand_u - curr_u;

	            if(deltaResult > 0)
	            {
	                curr_u = cand_u;
	            }
	            else
	                if(rand() <= Math.exp(deltaResult/temp))
	                {
	                    curr_u = cand_u;
	                }

	            temp = 0.99998 * temp;

	            if(curr_u > max)
	            {
	                max = curr_u;
	            }

	            System.out.println(format.format(max));

	        }while(minTemp < temp || curr_u >= threshold);

	            //System.out.println(format.format(max));
	    }


	    public static double question2A(){
	        double value = 0;

	       //result =


	        return value;
	    }

	    public static double rand(){
	        double randMax = 1;
	        double randMin = 0;

	        double diff = randMax - randMin;
	        double randVal = randMin + Math.random() * diff;

	        return randVal;
	    }
}
