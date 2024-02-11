package alg.p32;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class Tests {
	@Test
	public void city1BruteForce() {
		SkylineProblem problem = new SkylineProblem("city.txt");
		problem.solveBruteForce();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(2, output.get(0).x); assertEquals(10, output.get(0).y);
		assertEquals(3, output.get(1).x); assertEquals(15, output.get(1).y);
		assertEquals(7, output.get(2).x); assertEquals(12, output.get(2).y);
		assertEquals(12, output.get(3).x); assertEquals(0, output.get(3).y);
		assertEquals(15, output.get(4).x); assertEquals(10, output.get(4).y);
		assertEquals(20, output.get(5).x); assertEquals(8, output.get(5).y);
		assertEquals(24, output.get(6).x); assertEquals(0, output.get(6).y);
	}
	
	@Test
	public void city1DivideAndConquer() {
		SkylineProblem problem = new SkylineProblem("city.txt");
		problem.solveDivideAndConquer();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(2, output.get(0).x); assertEquals(10, output.get(0).y);
		assertEquals(3, output.get(1).x); assertEquals(15, output.get(1).y);
		assertEquals(7, output.get(2).x); assertEquals(12, output.get(2).y);
		assertEquals(12, output.get(3).x); assertEquals(0, output.get(3).y);
		assertEquals(15, output.get(4).x); assertEquals(10, output.get(4).y);
		assertEquals(20, output.get(5).x); assertEquals(8, output.get(5).y);
		assertEquals(24, output.get(6).x); assertEquals(0, output.get(6).y);
	}
	
	@Test
	public void city2BruteForce() {
		SkylineProblem problem = new SkylineProblem("city2.txt");
		problem.solveBruteForce();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(1, output.get(0).x); assertEquals(20, output.get(0).y);
		assertEquals(2, output.get(1).x); assertEquals(40, output.get(1).y);
		assertEquals(6, output.get(2).x); assertEquals(10, output.get(2).y);
		assertEquals(7, output.get(3).x); assertEquals(0, output.get(3).y);
	}
	
	@Test
	public void city2DivideAndConquer() {
		SkylineProblem problem = new SkylineProblem("city2.txt");
		problem.solveDivideAndConquer();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(1, output.get(0).x); assertEquals(20, output.get(0).y);
		assertEquals(2, output.get(1).x); assertEquals(40, output.get(1).y);
		assertEquals(6, output.get(2).x); assertEquals(10, output.get(2).y);
		assertEquals(7, output.get(3).x); assertEquals(0, output.get(3).y);
	}
	
	@Test
	public void city3BruteForce() {
		SkylineProblem problem = new SkylineProblem("city3.txt");
		problem.solveBruteForce();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(0, output.get(0).x); assertEquals(10, output.get(0).y);
		assertEquals(1, output.get(1).x); assertEquals(32, output.get(1).y);
		assertEquals(2, output.get(2).x); assertEquals(95, output.get(2).y);
		assertEquals(19, output.get(3).x); assertEquals(0, output.get(3).y);
	}
	
	@Test
	public void city3DivideAndConquer() {
		SkylineProblem problem = new SkylineProblem("city3.txt");
		problem.solveDivideAndConquer();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(0, output.get(0).x); assertEquals(10, output.get(0).y);
		assertEquals(1, output.get(1).x); assertEquals(32, output.get(1).y);
		assertEquals(2, output.get(2).x); assertEquals(95, output.get(2).y);
		assertEquals(19, output.get(3).x); assertEquals(0, output.get(3).y);
	}
	
	@Test
	public void city4BruteForce() {
		SkylineProblem problem = new SkylineProblem("city4.txt");
		problem.solveBruteForce();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(0, output.get(0).x); assertEquals(66, output.get(0).y);
		assertEquals(3, output.get(1).x); assertEquals(92, output.get(1).y);
		assertEquals(8, output.get(2).x); assertEquals(64, output.get(2).y);
		assertEquals(10, output.get(3).x); assertEquals(89, output.get(3).y);
		assertEquals(11, output.get(4).x); assertEquals(50, output.get(4).y);
		assertEquals(13, output.get(5).x); assertEquals(40, output.get(5).y);
		assertEquals(14, output.get(6).x); assertEquals(0, output.get(6).y);
	}
	
	@Test
	public void city4DivideAndConquer() {
		SkylineProblem problem = new SkylineProblem("city4.txt");
		problem.solveDivideAndConquer();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(0, output.get(0).x); assertEquals(66, output.get(0).y);
		assertEquals(3, output.get(1).x); assertEquals(92, output.get(1).y);
		assertEquals(8, output.get(2).x); assertEquals(64, output.get(2).y);
		assertEquals(10, output.get(3).x); assertEquals(89, output.get(3).y);
		assertEquals(11, output.get(4).x); assertEquals(50, output.get(4).y);
		assertEquals(13, output.get(5).x); assertEquals(40, output.get(5).y);
		assertEquals(14, output.get(6).x); assertEquals(0, output.get(6).y);
	}
	
	@Test
	public void city5BruteForce() {
		SkylineProblem problem = new SkylineProblem("city5.txt");
		problem.solveBruteForce();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(3, output.get(0).x); assertEquals(96, output.get(0).y);
		assertEquals(6, output.get(1).x); assertEquals(75, output.get(1).y);
		assertEquals(8, output.get(2).x); assertEquals(82, output.get(2).y);
		assertEquals(10, output.get(3).x); assertEquals(38, output.get(3).y);
		assertEquals(14, output.get(4).x); assertEquals(17,output.get(4).y);
		assertEquals(15, output.get(5).x); assertEquals(32, output.get(5).y);
		assertEquals(20, output.get(6).x); assertEquals(17, output.get(6).y);
		assertEquals(21, output.get(7).x); assertEquals(37, output.get(7).y);
		assertEquals(23, output.get(8).x); assertEquals(69, output.get(8).y);
		assertEquals(25, output.get(9).x); assertEquals(0, output.get(9).y);
		assertEquals(28, output.get(10).x); assertEquals(45, output.get(10).y);
		assertEquals(29, output.get(11).x); assertEquals(91, output.get(11).y);
		assertEquals(31, output.get(12).x); assertEquals(45, output.get(12).y);
		assertEquals(32, output.get(13).x); assertEquals(88, output.get(13).y);
		assertEquals(33, output.get(14).x); assertEquals(97, output.get(14).y);
		assertEquals(37, output.get(15).x); assertEquals(0, output.get(15).y);
	}
	
	@Test
	public void city5DivideAndConquer() {
		SkylineProblem problem = new SkylineProblem("city5.txt");
		problem.solveDivideAndConquer();
		List<KeyPoint> output = problem.getSolution();
		assertEquals(3, output.get(0).x); assertEquals(96, output.get(0).y);
		assertEquals(6, output.get(1).x); assertEquals(75, output.get(1).y);
		assertEquals(8, output.get(2).x); assertEquals(82, output.get(2).y);
		assertEquals(10, output.get(3).x); assertEquals(38, output.get(3).y);
		assertEquals(14, output.get(4).x); assertEquals(17,output.get(4).y);
		assertEquals(15, output.get(5).x); assertEquals(32, output.get(5).y);
		assertEquals(20, output.get(6).x); assertEquals(17, output.get(6).y);
		assertEquals(21, output.get(7).x); assertEquals(37, output.get(7).y);
		assertEquals(23, output.get(8).x); assertEquals(69, output.get(8).y);
		assertEquals(25, output.get(9).x); assertEquals(0, output.get(9).y);
		assertEquals(28, output.get(10).x); assertEquals(45, output.get(10).y);
		assertEquals(29, output.get(11).x); assertEquals(91, output.get(11).y);
		assertEquals(31, output.get(12).x); assertEquals(45, output.get(12).y);
		assertEquals(32, output.get(13).x); assertEquals(88, output.get(13).y);
		assertEquals(33, output.get(14).x); assertEquals(97, output.get(14).y);
		assertEquals(37, output.get(15).x); assertEquals(0, output.get(15).y);
	}
	 
}
