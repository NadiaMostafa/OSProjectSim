import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public  class Synchronize implements Buffer
{
	
	Lock accessLock = new ReentrantLock();
	Condition canWrite =accessLock.newCondition();
	Condition canRead =accessLock.newCondition();
	
	int buffer =-1;
	boolean occupied=false;   //buffer is not occupied
	
	
	
	
	
	public void set(int value) throws InterruptedException
	{
		accessLock.lock();
		
		try{
			while(occupied){
			
			System.out.println("producer tries to write");
			System.out.println("buffer-fulls: probucer-waits");
			canWrite.await();	
		    }
			
			buffer= value;
			occupied=true;
			System.out.println("producer writes: " + buffer);
			canRead.signalAll();
			
		}
		finally{
		accessLock.unlock();
	}
	}
	
	
	public int get() throws InterruptedException
	{
		int read_value=0;
		accessLock.lock();
		
		try{
			while(!occupied){
				System.out.println("consumer trys to read ");
				System.out.println("Buffer-empty:consumer waits");
				canRead.await();
			}
			occupied=false;
			read_value=buffer;
			System.out.println("consumer reads"+read_value);
			canWrite.signalAll();
			
		}
		finally{
			accessLock.unlock();
		}
		return read_value;
		
		
	}
		
	
}