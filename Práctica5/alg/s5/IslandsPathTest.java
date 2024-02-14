package alg.s5;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;


/**
 * JUnit Test for Islands Path
 */
public class IslandsPathTest {

	@Test
	public void test1() {
		IslandsPath problem = new IslandsPath("files/islas01.txt");
		executeFromFile(problem);
		ArrayList<String> paths = problem.getPaths();
		assertEquals("0 -> 1", paths.get(0));
		assertEquals("0 -> 2", paths.get(1));
		assertEquals("1 -> 0", paths.get(2));
		assertEquals("1 -> 0 -> 2", paths.get(3));
		assertEquals("2 -> 0", paths.get(4));
		assertEquals("2 -> 0 -> 1", paths.get(5));
	}
	
	@Test
	public void test2() {
		IslandsPath problem = new IslandsPath("files/islas02.txt");
		executeFromFile(problem);
		ArrayList<String> paths = problem.getPaths();
		assertEquals("0 -> 3 -> 1", paths.get(0));
		assertEquals("0 -> 3 -> 2", paths.get(1));
		assertEquals("0 -> 3", paths.get(2));
		assertEquals("1 -> 3 -> 0", paths.get(3));
		assertEquals("1 -> 3 -> 2", paths.get(4));
		assertEquals("1 -> 3", paths.get(5));
		assertEquals("2 -> 3 -> 0", paths.get(6));
		assertEquals("2 -> 3 -> 1", paths.get(7));
		assertEquals("2 -> 3", paths.get(8));
		assertEquals("3 -> 0", paths.get(9));
		assertEquals("3 -> 1", paths.get(10));
		assertEquals("3 -> 2", paths.get(11));
	}
	
	@Test
	public void test3() {
		IslandsPath problem = new IslandsPath("files/islas03.txt");
		executeFromFile(problem);
		ArrayList<String> paths = problem.getPaths();
		assertEquals("0 -> 2 -> 4 -> 1", paths.get(0));
		assertEquals("0 -> 2", paths.get(1));
		assertEquals("0 -> 2 -> 4 -> 1 -> 3", paths.get(2));
		assertEquals("0 -> 2 -> 4", paths.get(3));
		assertEquals("0 -> 2 -> 4 -> 1 -> 3 -> 6", paths.get(4));
		assertEquals("1 -> 2 -> 0", paths.get(5));
		assertEquals("1 -> 2", paths.get(6));
		assertEquals("1 -> 3", paths.get(7));
		assertEquals("1 -> 2 -> 4", paths.get(8));
		assertEquals("1 -> 3 -> 6", paths.get(9));
		assertEquals("2 -> 0", paths.get(10));
		assertEquals("2 -> 4 -> 1", paths.get(11));
		assertEquals("2 -> 4 -> 1 -> 3", paths.get(12));
		assertEquals("2 -> 4", paths.get(13));
		assertEquals("2 -> 4 -> 1 -> 3 -> 6", paths.get(14));
		assertEquals("3 -> 1 -> 2 -> 0", paths.get(15));
		assertEquals("3 -> 1", paths.get(16));
		assertEquals("3 -> 1 -> 2", paths.get(17));
		assertEquals("3 -> 1 -> 2 -> 4", paths.get(18));
		assertEquals("3 -> 6", paths.get(19));
		assertEquals("4 -> 1 -> 2 -> 0", paths.get(20));
		assertEquals("4 -> 1", paths.get(21));
		assertEquals("4 -> 1 -> 2", paths.get(22));
		assertEquals("4 -> 1 -> 3", paths.get(23));
		assertEquals("4 -> 1 -> 3 -> 6", paths.get(24));
	}
	
	@Test
	public void test4() {
		IslandsPath problem = new IslandsPath("files/islas04.txt");
		executeFromFile(problem);
		ArrayList<String> paths = problem.getPaths();
		assertEquals("0 -> 4 -> 1", paths.get(0));
		assertEquals("0 -> 4 -> 2", paths.get(1));
		assertEquals("0 -> 3", paths.get(2));
		assertEquals("0 -> 4", paths.get(3));
		assertEquals("1 -> 0", paths.get(4));
		assertEquals("1 -> 0 -> 4 -> 2", paths.get(5));
		assertEquals("1 -> 0 -> 3", paths.get(6));
		assertEquals("1 -> 0 -> 4", paths.get(7));
		assertEquals("2 -> 3 -> 0", paths.get(8));
		assertEquals("2 -> 4 -> 1", paths.get(9));
		assertEquals("2 -> 3", paths.get(10));
		assertEquals("2 -> 4", paths.get(11));
		assertEquals("3 -> 0", paths.get(12));
		assertEquals("3 -> 0 -> 4 -> 1", paths.get(13));
		assertEquals("3 -> 0 -> 4 -> 2", paths.get(14));
		assertEquals("3 -> 0 -> 4", paths.get(15));
		assertEquals("4 -> 0", paths.get(16));
		assertEquals("4 -> 1", paths.get(17));
		assertEquals("4 -> 2", paths.get(18));
		assertEquals("4 -> 0 -> 3", paths.get(19));
	}
	
	@Test
	public void test5() {
		IslandsPath problem = new IslandsPath("files/islas05.txt");
		executeFromFile(problem);
		ArrayList<String> paths = problem.getPaths();
		assertEquals("0 -> 1", paths.get(0));
		assertEquals("0 -> 1 -> 2", paths.get(1));
		assertEquals("1 -> 2 -> 0", paths.get(2));
		assertEquals("1 -> 2", paths.get(3));
		assertEquals("2 -> 0", paths.get(4));
		assertEquals("2 -> 0 -> 1", paths.get(5));
	}
	
	private void executeFromFile(IslandsPath problem) {
		System.out.println("Widths");
		System.out.println(problem);
		problem.calculateMaximumWidths();
		System.out.println("Costs matrix");
		problem.printCostsMatrix();
		System.out.println("Paths matrix");
		problem.printPathsMatrix();
		System.out.println("The islands that each road crosses");
		problem.generatePaths();
	}
		
}
