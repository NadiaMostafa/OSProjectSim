import java.util.LinkedList;

class FolderOrFile{
	String name;
	String dateCreated;
	Folder parent;
	
	public FolderOrFile(String name, Folder parent){
		this.name = name;
		this.parent = parent;
	}
}

class Folder extends FolderOrFile{
	LinkedList<FolderOrFile> contents;
	
	public Folder(String name, Folder parent){
		super(name,parent);
		contents = new LinkedList<FolderOrFile>();
	}
}
 
class File extends FolderOrFile{
	String extention;
	String type;
	public File(String name, String extention, Folder parent){
		super(name,parent);
		this.extention = extention;
	}
}

public class FileSystem {
	Folder mountPoint = new Folder("zero", null);
	Folder root;
	FolderOrFile temp;
	Folder currentLocation;
	public FileSystem(){
		root = new Folder("This PC",mountPoint);
		mountPoint.contents.add(root);
		currentLocation = mountPoint;
		
	}
	
	public void createFolder(String name){
		for(FolderOrFile F:currentLocation.contents){
			if(F.name.equals(name)){
				if(F instanceof Folder){
					System.out.println("This destination already contains a folder named '" + name +"'.Choose another name!");
					return;
				}
			}
		}
		Folder newFolder = new Folder(name,currentLocation);
		currentLocation.contents.add(newFolder);
		displayContents();
	}
	public void createFile(String name, String extention){
		for(FolderOrFile F:currentLocation.contents){
			if(F.name.equals(name)){
				if(F instanceof File && ((File) F).extention.equals(name)){
					System.out.println("There is already a file with this name in this location.");
					return;
				}
			}
		}
		File newFile = new File(name,extention,currentLocation);
		currentLocation.contents.add(newFile);
		displayContents();
	}
	public void open (String name){
		for(FolderOrFile F:currentLocation.contents){
			if(F.name.equals(name)){
				if(F instanceof Folder){
					currentLocation = (Folder)F;
					displayContents();
				}
				else{
					System.out.println("File " + F.name + " is opend.\n");
				}
			}
		}
	}
	public void copy(String name){
		for(FolderOrFile F:currentLocation.contents){
			if(F.name.equals(name)){
				temp = F;
				return;
			}

		}
	}
	public void cut(String name){
		for(FolderOrFile F:currentLocation.contents){
			if(F.name.equals(name)){
				temp = F;
				currentLocation.contents.remove(F);
				return;
			}
		}
	}
	
	public void paste(){
		if (temp == null)
			return;
		temp.parent = currentLocation;
		currentLocation.contents.add(temp);
		displayContents();
	}
	public void displayContents(){
		int cnt = 0;
		System.out.println(currentLocation.name+":");
		for(FolderOrFile F:currentLocation.contents){
			if(F instanceof Folder)
				System.out.println("   "+F.name);
			else if(F instanceof File)
				System.out.println("   "+F.name +"."+ ((File)F).extention);
			cnt ++;
		}
		if (cnt == 0)System.out.println("   This folder is empty");
		System.out.print("\n");
	
	}
	
	public void rename(String oldName, String newName){
		for(FolderOrFile F:currentLocation.contents){
			if(F.name.equals(oldName)){
				F.name = newName;
                                displayContents();
				return;
			}
	
		}
	}
	public void delete(String name){
		for(FolderOrFile F:currentLocation.contents){
			if(F.name.equals(name)){
				currentLocation.contents.remove(F);
				return;
			}
		}
	}
	public void back(){
		if (currentLocation.parent != null){
			currentLocation = currentLocation.parent;
			displayContents();
		}
	}
	public void closeFile(String name){
		System.out.println("File " + name + " has been closed.\n");
	}
	public void closeFolder(){
		currentLocation = mountPoint;
	}
	
}
	
