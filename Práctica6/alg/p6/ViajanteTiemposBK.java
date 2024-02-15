package alg.p6;

import java.util.Random;

public class ViajanteTiemposBK {
	
	private static int[][] generarMatrizAleatoria(int tamaño) {
		int[][] devolver=new int[tamaño][tamaño];
		Random r=new Random();
		for(int i=0;i<tamaño;i++) {
			for(int j=0;j<tamaño;j++) {
				if(i==j) {
					devolver[i][j]=0;
				}else {
					devolver[i][j]=r.nextInt(10,100);
				}
			}
		}
		return devolver;
		
	}
	public static void main(String[] args) {
		for(int i=10;i<Integer.MAX_VALUE;i++) {
			int[][] matriz=generarMatrizAleatoria(i);
			long t1=System.currentTimeMillis();
			ViajanteBK v=new ViajanteBK(matriz);
			v.resolver();
			long t2=System.currentTimeMillis();
			System.out.println("Tamaño: "+i+"\tTiempo(ms): "+(t2-t1));
		}
	}
}
