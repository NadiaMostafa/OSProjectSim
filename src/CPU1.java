/**
 * 
 * @author Safwa
 *
 */public class CPU1 {

	Queue readyQ;
	IO i_o;

	public CPU1 ()
	{
		readyQ = new Queue ();
		i_o = new IO(this);
	}
	
	public void dispatcher()
	{
		while (!readyQ.isEmpty())
		{			
			System.out.println( "readyQ now ");
			readyQ.displayQueue();
			System.out.println( "Process "+readyQ.theList.first.p.name+" in Dispatcher");
			running (readyQ.theList.first.p);
		}
	}
	
	public void running(Process o)
	{
		System.out.println( "Process "+o.name+" in running function");
		
		while( o.duration> 0) 
		{
			if(o.Brust[o.index]==0) // 0 mean need i/o
			{
				i_o.duringIO(o);

			}
			else 
			{				
				System.out.print("CPU doing one cycle for Process "+o.name );
				
				System.out.println("  its duration is  "+ o.duration );
				o.duration --;
				o.index++; //shaka fiky
			}
		}
		terminate (o);
	}
	
	public void terminate (Process o)
	{
		System.out.println( "Process "+o.name+" in terminate function");
		if (!readyQ.isEmpty())readyQ.remove();
		System.out.println("readyQ after removing Process "+ o.name);
			
		
	}
 }