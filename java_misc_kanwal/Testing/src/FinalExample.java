import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class X
{
    void calculate(int a, int b)
    {
        System.out.println("Class X");
    }
}
 
class Y extends X
{
    @Override
    void calculate(int a, int b)
    {
        System.out.println("Class Y");
    }
}
 
class Z extends Y
{
    @Override
    void calculate(int a, int b) 
    {
        System.out.println("Class Z");
    }
}
 
public class FinalExample 
{    
    public static void main(String[] args)
    {
        		
        		ThreadPoolExecutor p = new ThreadPoolExecutor(10, 10,
                        0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());
        		
        		int i = 0;
        		for( i = 0; i < 100; i++)
        		{
        			p.execute(new sss());
        		}
        		
    }
}
	


 


