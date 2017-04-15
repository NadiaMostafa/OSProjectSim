//package osprojectsim;
import java.util.*;
public class Process {

    public String name;
    public int id;  
    public int size;
    public int duration;  //time remaining
    public int pageTable[];
    public int index;
    public int Brust[];
    
    public Process(String name,int id,int size,int duration){
        
        Random rand = new Random();
        this.name=name;
        this.id = id;
        System.out.println("intializing PID " + this.id +" process is "+ this.name);   
        Brust = new int[duration];
        index = 0;
        Brust = new int[duration];
        for(int i=1;i<duration-1;i++){
            Brust[i]=rand.nextInt(2);
        }
        Brust[0] = Brust[duration-1] = 1;
        this.size=size;
        this.duration=duration;
        pageTable=new int[size];
        
    }
    
}