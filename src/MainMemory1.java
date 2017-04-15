public class MainMemory1 {
	int memorySize=64;
	Queue Q;
	boolean[] frame = new boolean[memorySize];
	int freeFrams=64;
	public MainMemory1(){		//constructor
		
		Q = new Queue();		//queue of process p

		for(int i=0;i<64;i++){		// default false for all items of frame
			frame[i]=false;
		}		 
	}
	public void Allocation(Process p){
		if (freeFrams < p.size){
			Replacement(p);
		}
			
		else{
			System.out.println("Process "+p.name+" Allocated");
			System.out.println("Process "+p.name+ " Page table is   \n" );
			System.out.println("	Page		Frame  \n" );

			for(int j =0 ;j<p.size;j++){
				for(int iD=0;iD<memorySize ;iD++){		
					if (frame[iD]==true);					// do nothing             //check
					else{
						frame[iD]=true;
						p.pageTable[j]=iD;		//check
						freeFrams--;
						System.out.printf( "	%4d		%5d\n",j,p.pageTable[j] );
						break;
					}	
				} 
			}
			Q.insert(p);
		}//end else

	}			//end allocation
	//------------------------------------
	
	public void Deallocation (Process p){
		
		for(int i=0;i<p.size;i++){
			int id=p.pageTable[i];
			frame[id]=false;	
			freeFrams++;
		}
		//Q.remove();
		System.out.println("Process "+p.name+" Deallocated/n");

		}
			
		//--------------------------------------------------------
		
	
	public void Replacement(Process p){ //n. of pages needed
		while(freeFrams<p.size){
			Process temp=Q.remove(); //return temp
			for(int i=0;i<temp.size;i++){
				int id=temp.pageTable[i];
				frame[id]=false;
				freeFrams++;
			}
			System.out.println("Process "+temp.name+"  Replaced\n");

		}
		
			
		System.out.println("Process "+p.name+" Allocated");
		System.out.println("Process "+p.name+ " Page table is   \n" );
		System.out.println("	Page		Frame  \n" );

		for(int j=0;j<p.size;j++){
			for(int iD=0;iD<memorySize ;iD++){		
				if (frame[iD]==true);					// do nothing             //check
				else{
					frame[iD]=true;
					freeFrams--;
					p.pageTable[j]=iD;		//check
					System.out.printf( "	%4d		%5d\n",j,p.pageTable[j] );
					break;
				}	
			}	
		}   //end for

		Q.insert(p);

	}   // end of replacement
	
    


	}// end class
