package alg.s5;

public class IslandsPathTimes {

	public static void main(String[] args) {
		for(int n=100;n<Integer.MAX_VALUE;n*=2) {
			IslandsPath island=new IslandsPath(n);
			long t1 = System.currentTimeMillis();
			island.generatePaths();
			long t2 = System.currentTimeMillis();
			System.out.printf("size:%d - time:%d ms\n", n, t2-t1);
		}
	}
}
