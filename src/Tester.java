/**
 * A Tester module to test printing
 * 
 * @author zshulu
 *
 */

public class Tester {
	public static void main(String[] args) {
		Course c = new Course(
				"GIN221",
				"Introduction a la programmation",
				"8:00",
				"10:00",
				3
		);
		
		Course v = new Course(
				"GIN231",
				"Structures de donnees et algorithmes",
				"18:00",
				"1:50",
				3
		);
		
		Course b = new Course(
				"GMC430",
				"Resistance des Materiaux",
				"11:00",
				"12:50",
				2
		);
		
		System.out.println(c);
		System.out.println(v);
		System.out.println(b);
	}

}
