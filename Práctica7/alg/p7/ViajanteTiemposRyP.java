
package alg.p7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ViajanteTiemposRyP {
	public static final int VECES=5;
	public static final int TAMAÑO_MAXIMO=35;
	public static final int TAMAÑO_MINIMO=10;
	public static final int INCREMENTO_TAMAÑO=5;
	private static int[][] leerArchivo(int vez, int tamaño){
		String cadena; 
		int[][] matrizPesos=new int[tamaño][tamaño];
		try{
			BufferedReader b = new BufferedReader(new FileReader("files/grafoGenerado"+vez+"Tamaño"+tamaño+".txt")); 
			int i=0;
			while((cadena = b.readLine())!=null) { 
				String[] splits=cadena.split(" ");
				for(int j=0;j<splits.length;j++) {
					matrizPesos[i][j]=Integer.parseInt(splits[j]);
				}
				i++;
			} 
			b.close();
		}catch(FileNotFoundException e){

		}catch(IOException e){

		}
		return matrizPesos;
	}
	public static void main(String[] args) {
		for(int tamaño=TAMAÑO_MINIMO;tamaño<TAMAÑO_MAXIMO;tamaño+=INCREMENTO_TAMAÑO) {
			long[] tiempos=new long[VECES];//Para almacenar los tiempos de cada vez para cada tamaño
			long media=0;
			for(int vez=0;vez<VECES;vez++) {
				int[][] matriz=leerArchivo(vez,tamaño);
				long t1=System.currentTimeMillis();
				ViajanteRyP v=new ViajanteRyP(matriz);
				v.resolver();
				long t2=System.currentTimeMillis();
				tiempos[vez]=t2-t1;
			}
			for(int i=0;i<tiempos.length;i++) {
				media+=tiempos[i];
			}
			media/=VECES;
			System.out.println("Tamaño: "+tamaño+"\tTiempo(ms): "+(media));
		}
	}
}
