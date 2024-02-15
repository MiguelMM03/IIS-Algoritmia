package alg.p7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViajanteBK {

	private int[][] matrizPesos;
	private int numNodos;
	private int[] solucion;
	private double costeSolucion=Double.POSITIVE_INFINITY;
	private String archivo;
	
	public ViajanteBK(String archivo) {
		obtenerNumeroDeNodos(archivo);
		leerArchivo(archivo);
		this.archivo=archivo;
		
	}
	
	public void showMatrizPesos() {
		for(int i=0;i<numNodos;i++) {
			for(int j=0;j<numNodos;j++) {
				System.out.print(matrizPesos[i][j]+" ");
			}
			System.out.println();
		}
	}
	public ViajanteBK(int[][] matriz) {
		if(matriz.length==0 || matriz.length!=matriz[0].length) {
			throw new IllegalArgumentException("La matriz dada no puede tener longitud 0 y tiene que ser cuadrada");
		}
		matrizPesos=matriz;
		numNodos=matriz.length;
		solucion=new int[numNodos+1];
	}
	private void obtenerNumeroDeNodos(String archivo) {
		numNodos=Integer.parseInt(archivo.substring(archivo.length()-6,archivo.length()-4));
		matrizPesos=new int[numNodos][numNodos];
		solucion=new int[numNodos+1];
		
	}
	public  void leerArchivo(String archivo){
		String cadena; 
		try{
			BufferedReader b = new BufferedReader(new FileReader(archivo)); 
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
	}
	public void resolver() {
		List<Integer> sol=new ArrayList<Integer>();
		List<Integer> visitados=new ArrayList<Integer>();
		backtracking(0,visitados,sol, 0);
		
	}
	private void backtracking(int nivel, List<Integer> visitados, List<Integer> sol, int coste) {
		
		if(nivel==numNodos) {
			sol.add(sol.get(0));
			coste+=matrizPesos[sol.get(sol.size()-2)][sol.get(0)];
			if(coste<costeSolucion) {
				costeSolucion=coste;
				for(int i=0;i<sol.size();i++) {
					solucion[i]=sol.get(i);
				}
			}
			
			sol.remove(sol.size()-1);
			coste-=matrizPesos[sol.get(sol.size()-1)][sol.get(0)];
		}
		else if(nivel<numNodos) {
			if(visitados.size()==0) {
				visitados.add(0);
				sol.add(0);
				backtracking(nivel+1,visitados,sol,coste);
				visitados.remove(0);
				sol.remove(0);
			}
			else{
				for(int i=0;i<numNodos;i++){
					if(!visitados.contains(i)) {
						visitados.add(i);
						sol.add(i);
						coste+=matrizPesos[sol.get(sol.size()-2)][i];
						backtracking(nivel+1,visitados,sol,coste);
						visitados.remove(Integer.valueOf(i));
						sol.remove(Integer.valueOf(i));
						coste-=matrizPesos[sol.get(sol.size()-1)][i];
					}
				}
			}
		}
		
	}
	
	public void showResult() {
		System.out.println("---------SOLUCION-----------");
		System.out.println("Archivo: "+archivo);
		System.out.println("Numero de nodos: "+numNodos);
		for(int i=0;i<solucion.length;i++) {
			System.out.print(solucion[i]+" ");
		}
		System.out.println("\tCoste: "+costeSolucion);
		System.out.println("----------------------------");
	}
	public static void main(String[] args) {
		ViajanteBK v=new ViajanteBK("files/grafo10.txt");
		v.showMatrizPesos();
		v.resolver();
		v.showResult();
	}
}
