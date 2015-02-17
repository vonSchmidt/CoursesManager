import java.io.*;
import java.util.Scanner;

/**
 * 
 * Course Search Engine Module:
 * 
 * Searches for a CourseID in the Index File
 * If Available, the Corresponding Line from
 * db.txt will be Printed on Screen.
 * 
 * @author zshulu
 *
 */

public class SearchForCourses{
	public static void main(String args[]) throws IOException{
		System.out.print("Enter Codename of the Desired Course: ");
		Scanner q = new Scanner(System.in);
		String x = q.next().toUpperCase();


		File index = new File("index.txt");
		BufferedReader br = null;
		FileReader fr = null;
		
		try {

			br = new BufferedReader(
					new FileReader(index));


			String line;
			int l = 0;
			boolean found = false;
			
			while((line = br.readLine()) != null){
				if(line.contains(x)){
					found = true;
					l = Integer.parseInt(
							line.split("\t")[1]
					);
					break;
				}
			}
			
			br.close();
			
			if(!found){
				System.out.println("Course Not Found.");
				System.exit(1);
			}
			
			File db = new File("db.txt");
			fr = new FileReader(db);
			fr.skip((l-1)*(Course.RECORD_LENGTH + 1));
			br = new BufferedReader(fr);
			System.out.println(br.readLine());
			
		} catch (FileNotFoundException e) {
			System.err.println("File was Not Found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO Exception was Caught.");
			e.printStackTrace();
		} finally {
			fr.close();
			br.close();
		}
	}
}