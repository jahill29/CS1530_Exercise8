import java.util.*;
import java.math.*;

public class Pi {
    public static Long inside = 0L;
    
    public static void main(String[] args) {
        Long threads = 0L;
        Long iterations = 0L;
        try {
        threads = Long.parseLong(args[0]);
        iterations = Long.parseLong(args[1]);
        }
        
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        
        ArrayList<Thread> threadArray = new ArrayList<Thread>();
        System.out.println(threads);
        System.out.println(iterations);
        Long iterationSplit = iterations/threads;
        for (int i = 0; i < threads; i++)
        {
            Thread t = new Thread (() -> {
                for (int j = 0; j < iterationSplit; j++)
                {
                    Random rand1 = new Random();
                    float x = rand1.nextFloat();
                    float y = rand1.nextFloat();
                    if (x*x + y*y < 1)
                    {
                        inside++;
                    }
                }
                    
            });
            threadArray.add(t);
        }
        
        for (int k = 0; k < threadArray.size(); k++)
        {
            threadArray.get(k).start();
            try
            {
            threadArray.get(k).join();
            }
            catch(Exception e)
            {
                System.out.println(e.toString());
            }
        }
        
        System.out.println("Total = " + iterations);
        System.out.println("Inside = " + inside);
        Float ratio = (inside.floatValue()/iterations.floatValue());
        System.out.println("Ratio = " + ratio);
        Float pi = ratio * 4;
        System.out.println("Pi = " + pi);
               
    }
    
}