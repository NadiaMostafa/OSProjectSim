public class IO 
{

    CPU1 cpu ;
    
    public IO(CPU1 cpu){

        this.cpu = cpu;
    }

    public void duringIO (Process p)
    {
    	System.out.println( "Process "+p.name+" in duringIO function");
    
    	while (p.Brust[p.index]==0) //io
    	{	
    		
    			p.duration --;
    			System.out.print("IO doing one cycle for Process "+p.name );
				System.out.println("  its duration is "+ p.duration +" p.Burst[" +p.index+"]==0  ");
				p.index++;
		}
    		



    }
}
    	