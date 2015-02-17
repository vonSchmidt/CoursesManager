import java.io.*;
import java.util.LinkedList;

/**
 * 
 * Serializer Module:
 * Reads course records from text file
 * Pushes them into a Linked List
 * Serializes the List in a SRL file
 * 
 * @author zshulu
 *
 */

public class Serializer {

	public static void main(String[] args) throws IOException {
		
		LinkedList<Course> list = new LinkedList<Course>();
		File f = new File("courses.blah");
		BufferedReader br = null;
		ObjectOutputStream oos = null;
		try {
			
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
			System.out.println("Reading from Text File ...");
			String line;
			String rec [] = new String[5];
			
			while((line = br.readLine()) != null){
				rec = line.split(",");
				list.add(
						new Course(rec[0], rec[1],
								   rec[2], rec[3],
								   Integer.parseInt(rec[4]))
						);
			}
			System.out.println("Successfully Read from Text File.");
			
			File srl = new File("SerializedList.srl");
			if(!srl.exists())
				srl.createNewFile();
			oos = new ObjectOutputStream(
					new FileOutputStream(srl));
			System.out.println("Writing List Object to SRL File ...");
			oos.writeObject(list);
			System.out.println("Successfully Wrote List Object to SRL File.");
			
		} catch (FileNotFoundException e) {
			System.err.println("File was Not Found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO Exception was Caught.");
			e.printStackTrace();
		} finally{
				br.close();
				oos.close();
		}
		
	}
	
	public static void printList(LinkedList<Course> list){
		for(Course c : list){
			System.out.println(c);
		}
	}

}
