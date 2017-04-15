

	import java.util.Random;
	public class Consumer implements Runnable{
		Random generator =new Random();
		Buffer SharedLocation;
		public Consumer(Buffer Shared)
		{
			SharedLocation=Shared;
			
		}
		public void run(){
			int sum=0;
			for(int count =1 ;count<=10 ;count++){
				try{
					Thread.sleep(generator.nextInt(3000));
					SharedLocation.get();
					sum+=count;
					System.out.println(sum);
				}
				catch(InterruptedException exception){
					exception.printStackTrace();
					
				}
			}
			System.out.println("Consumer Finished  &Terminating");
			
		}

	}
