package alg.p32;

public class Times {

	public static void main(String[] args) {
		final int MAX_VALUE = 200_000;
		
		//BRUTE FORCE
		for (int n = 10; n<MAX_VALUE; n*=2) {
			SkylineProblem problem = new SkylineProblem(n);
			long t1 = System.currentTimeMillis();
			problem.solveBruteForce();
			long t2 = System.currentTimeMillis();
			System.out.printf("size:%d - time:%d ms\n", n, t2-t1);
		}
		
		System.out.printf("\n\n");
		
		//DIVIDE AND CONQUER
		for (int n = 10; n<MAX_VALUE; n*=2) {
			SkylineProblem problem = new SkylineProblem(n);
			long t1 = System.currentTimeMillis();
			problem.solveDivideAndConquer();
			long t2 = System.currentTimeMillis();
			System.out.printf("size:%d - time:%d ms\n", n, t2-t1);
		}
	}

}
