package alg.p6;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException;

public class RevientaClaves
{
	private List<Character> caracteres= new ArrayList<>();
	private List<String> clavesCodificadas=new ArrayList<>();
	private List<String> clavesDescodificadas=new ArrayList<>();
	public static final int NIVEL_MAXIMO=8;
	private String[] cadenas=new String[NIVEL_MAXIMO];
	private long t1;

	public RevientaClaves(String archivo){
		leerArchivo(archivo);
		//clavesCodificadas.add("0698e5edd8941b975fa25613e45fb2cd");
		generarMayusculas();
		t1=System.currentTimeMillis();
		descifrarClaves();
	}

	public void generarMayusculas(){
		for(char i='A';i<='Z';i++){
			if(i!='\u2018'){
				caracteres.add((char)i);
			}
		}
	}
	public void descifrarClaves(){
		for(int i=0;i<cadenas.length;i++) {
			cadenas[i]="";
		}
		backtracking(0);
	}


	private void backtracking(int nivel){
		//System.out.println(cadena);
		for(String clave : clavesCodificadas){
			if(getMD5(cadenas[nivel]).equals(clave)){
				clavesDescodificadas.add(cadenas[nivel]);
				//clavesCodificadas.remove(clave);
				System.out.println(cadenas[nivel] + "Tiempo: "+(System.currentTimeMillis()-t1));
			}
		}
		if(nivel<NIVEL_MAXIMO-1) {
			for(char c : caracteres){
				cadenas[nivel+1]=cadenas[nivel]+c;
				backtracking(nivel+1);
				cadenas[nivel+1]=cadenas[nivel+1].substring(0, cadenas[nivel+1].length()-1);
			}
		}
	}
	public String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public void leerArchivo(String archivo){
		String cadena; 
		try{
			BufferedReader b = new BufferedReader(new FileReader(archivo)); 
			while((cadena = b.readLine())!=null) { 
				clavesCodificadas.add(cadena);
			} 
			b.close();
		}catch(FileNotFoundException e){

		}catch(IOException e){

		}
	}

	public static void main (String args [] )
	{
		String archivo=args[0]; //archivo donde se encuentran almacenadas las claves codificadas
		new RevientaClaves(archivo);
		
	} // fin de main
} // fin de clase