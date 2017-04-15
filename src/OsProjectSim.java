import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OsProjectSim {

    
    public static void runFile(){
    	FileSystem F = new FileSystem();
    	F.open("This PC");
		F.createFolder("Nadia");
		F.createFolder("Yasmine");
		F.createFolder("Yasmine");
		F.open("Nadia");
		F.createFolder("Documents");
		F.open("Documents");
		F.createFile("a", "txt");
		F.createFile("b", "zip");
		F.createFile("c", "pdf");
		F.back();
		F.createFolder("Pictures");
		F.open("Pictures");
		F.createFile("1", "jpg");
		F.createFile("2", "jpg");
		F.back();
		F.createFile("Code","exe");
		F.back();
		F.open("Yasmine");
		F.createFile("Eclipse","exe");
		F.createFolder("Books");
		F.open("Books");
		F.createFile("Java", "pdf");
		F.createFile("C++", "pdf");
		F.back();
		F.createFolder("Videos");
		F.open("Videos");
		F.createFile("a", "mp4");
		F.createFile("b", "mp4");
		F.back();
		F.createFile("OS","java");
		F.closeFolder();
		
    }

    public static void runCpu() {
    	Process p1 = new Process ("a",1,10,10);
		Process p2 = new Process ("b",2,10,5);
		Process p3 = new Process ("c",3,10,15);

		
		CPU1 theCPU = new CPU1 ();
		theCPU.readyQ.insert(p1);
		theCPU.readyQ.insert(p2);
		theCPU.readyQ.insert(p3);
		theCPU.dispatcher();
    }

    public static void runMemory() {
        MainMemory1 m = new MainMemory1();
        Process p1=new Process("p1",1,50,3);
    	Process p2=new Process("p2",2,15,3);
    	Process p3=new Process("p3",3,3,3);
    	
    	m.Allocation(p1);
    	m.Allocation(p2);
    	m.Allocation(p3);
    	m.Deallocation(p2);

    }
    public static void TestSync(){
    	ExecutorService application =Executors.newCachedThreadPool();
		Buffer SharedLocation= new Synchronize();
		
		application.execute(new Producer(SharedLocation));
		application.execute(new Consumer(SharedLocation));
		application.shutdown();
    }
    public static void main(String[] args) {

        System.out.println("CPU Scheduling Test ");
        runCpu();
        System.out.println("Memory Test ");
        runMemory();
        System.out.println("Files Test ");
        runFile();
        System.out.println("Synchronization Test ");
        TestSync();
        

    }

}
