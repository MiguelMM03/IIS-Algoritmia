package alg.p7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneradorGrafosAleatorio {
	public static final int VECES=5;
	public static final int TAMAÑO_MAXIMO=15;
	public static final int TAMAÑO_MINIMO=10;
	public static final int INCREMENTO_TAMAÑO=1;
	public GeneradorGrafosAleatorio(int tamaño, int vez) {
		EscribirEnArchivo(generarMatrizAleatoria(tamaño), tamaño, vez);
	}
	private void EscribirEnArchivo(int[][] matriz, int tamaño, int vez) {
		try {
            FileWriter escritor = new FileWriter("files/grafoGenerado"+vez+"Tamaño"+tamaño+".txt");
            BufferedWriter buffer = new BufferedWriter(escritor);
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    buffer.write(matriz[i][j] + " ");
                }
                if(i<matriz.length-1)
                	buffer.newLine();
            }

            buffer.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir en el archivo con buffer.");
            e.printStackTrace();
        }
    }
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
		for(int veces=0;veces<VECES;veces++) {
			for(int n=TAMAÑO_MINIMO;n<TAMAÑO_MAXIMO;n+=INCREMENTO_TAMAÑO) {
				new GeneradorGrafosAleatorio(n,veces);
			}
		}
	}
}
