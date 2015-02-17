import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Deserializer Module:
 * Reads a List of Courses from a SRL file
 * Writes them in a db.txt Text File
 * Creates an Index File and sorts it
 * 
 * 
 * @author zshulu
 *
 */

public class Deserializer{
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		LinkedList<Course> list = null;
		File f = new File("SerializedList.srl");
		ObjectInputStream ois = null;
		BufferedWriter bwdb = null;
		BufferedWriter bwindx = null;
		
		try{
		ois = new ObjectInputStream(
				new FileInputStream(f));
		
		System.out.println("Reading List Object from SRL File ...");
		
		Object o = ois.readObject();
		if(o instanceof LinkedList<?>)
			list = (LinkedList<Course>)o;
		
		System.out.println("Successfully Retrieved List Object from SRL File.");
		
		File index = new File("index.txt");
		if(!index.exists()) index.createNewFile();
		File db = new File("db.txt");
		if(!db.exists()) db.createNewFile();
		
		bwdb = new BufferedWriter(
				new FileWriter(db)
		);
		
		bwindx = new BufferedWriter(
				new FileWriter(index)
		);
		
		List<String> indexList = new LinkedList<String>();
		
		int line = 1;
		
		for(Course rec : list){
			bwdb.write(rec.toString()+"\n");
			indexList.add(rec.getCourseID()+"\t"+ line++);
		}

	    System.out.println("Creating and Sorting Index File ...");
	    
	    Collections.sort(indexList);

	    for(String i : indexList)
	    	bwindx.write(i + "\n");
		
		} catch(IOException e){
			System.err.println("IO Exception was Caught.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("A Class Definition was Not Found.");
			e.printStackTrace();
		} finally {
			ois.close();
			bwdb.close();
			bwindx.close();
		}
		
		
	}

	public static void printList(LinkedList<Course> list){
		for(Course c : list){
			System.out.println(c);
		}
	}
	
}