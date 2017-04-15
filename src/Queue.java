//package osprojectsim;

public class Queue {


	LinkedList theList;

	public Queue() 
	{
		theList = new LinkedList(); 
	} 


	public boolean isEmpty() 
	{
		return theList.isEmpty(); 
	}


	public void insert(Process j) 
	{
		theList.insertLast(j); 
	}
	
	public Process remove() 
	{ 
		
		 return theList.deleteFirst();
		 
	}

	public void displayQueue()
	{
		System.out.println("First   --->    Last0");
		theList.displayList();
	}

}

class Link
{
	public Process p;
	public Link next; 

	public Link(Process p) 
	{ 
		this.p=p; 
		}
	public void displayLink()
	{ 
		System.out.println(p.name + " ");
		}
}

class LinkedList
{
	 Link first; 
	 Link last; 

	public LinkedList()
	{
		first = null; 
		last = null;
	}

	public boolean isEmpty()
	{ 
		return (first==null); 
		}

	public void insertLast(Process p) 
	{
		Link newLink = new Link(p);
		if( isEmpty() ) 
			first = newLink; 
		else
			last.next = newLink; // help
		
		last = newLink;
		}

	public Process deleteFirst() 
	{ 
		Process temp = first.p;
		first = first.next; 
		return temp;
	}

	public void displayList()
	{
		Link current = first; 
		while(current != null)
		{
			current.displayLink();
			current = current.next; 
		}
		System.out.println("");
	}
}

//public void displayLink()
//	{ 
//		System.out.println(p.name + " ");
//		}
//}