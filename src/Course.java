import java.io.Serializable;

/**
 * 
 * An instance of this class represents a Course
 * Example:
 * CourseID = GIN221
 * CourseName = Intro. a la prog.
 * StartTime = 9:20 or 12:35
 * nbCredits = 3
 * 
 * @author zshulu
 *
 */

public class Course implements Serializable{

	private static final long serialVersionUID = 7906962020344840766L;
	
	private String courseID;
	private String courseName;
	private String startTime;
	private String endTime;
	private int nbCredits;
	
	public static final int RECORD_LENGTH = 60;
	
	public Course(String cid, String cn, String st, String et, int n){
		courseID = cid;
		courseName = cn;
		startTime = st;
		endTime = et;
		nbCredits = n;
	}
	
	
	public String getCourseID(){ return courseID; }
	public String getCourseName(){ return courseName; }
	public String getStartTime(){ return startTime; }
	public String getEndTime(){ return endTime; }
	public int getNbCredits(){ return nbCredits; }
	
	public String toString(){
		return String.format("%1$6s", courseID)+" "+
					String.format("%1$39s", courseName)+" "+
				String.format("%1$5s", startTime)+" "+
					String.format("%1$5s", endTime)+" "+nbCredits;
	}
	
	
}
