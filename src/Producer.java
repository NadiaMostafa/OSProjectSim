
import java.util.Random;
public class Producer implements Runnable{
	Random generator =new Random();
	Buffer SharedLocation;
	public Producer(Buffer Shared)
	{
		SharedLocation=Shared;
		
	}
	public void run(){
		int sum=0;
		for(int count =1 ;count<=10 ;count++){
			try{
				Thread.sleep(generator.nextInt(3000));
				SharedLocation.set(count);
				sum+=count;
				System.out.println(sum);
			}
			catch(InterruptedException exception){
				exception.printStackTrace();
				
			}
		}
		System.out.println("Producer done producing &Terminating");
		
	}

}
