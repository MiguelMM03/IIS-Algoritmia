package alg.p32;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
public class SkylineProblem {

	private List<Building> input=new ArrayList<>(); 
	private List<KeyPoint> puntosClave=new ArrayList<>(); 
	private Skyline skyline; 
	/**
	 * Creates a solution from a text file
	 * @param fileName the name of the file to be processed with the input data
	 */
	public SkylineProblem(String fileName) {
		File f=new File(fileName);
		try{
			BufferedReader br=new BufferedReader(new FileReader(f));
			String linea=null;
			while((linea=br.readLine())!=null){
				String[] datos=linea.split(" ");
				int left=Integer.parseInt(datos[0]);
				int right=Integer.parseInt(datos[1]);
				int height=Integer.parseInt(datos[2]);
				
				input.add(new Building(left, right, height));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Creates a random solution with a given number of buildings
	 * @param nBuildings the number of desired buildings in the skyline
	 */
	@SuppressWarnings("unused")
	public SkylineProblem(int nBuildings) {
		int positions = 2*nBuildings; //the number of positions in the skyline is proportional to the number of buildings
		for (int i = 0; i < nBuildings; i++) {
			int left = new Random().nextInt(positions-5); //should leave some positions to place the building
			int right = left + 1 + new Random().nextInt(5); //should be a little bigger than left to get a valid position
			int height = new Random().nextInt(90) + 10; //between 10 and 99 meters
			//do something with the new randomly created building


			input.add(new Building(left, right, height));
			
		}
	}
	
	/**
	 * Prints the buildings' information given to the problem
	 */
	public void printBuildings() {
		for(Building building :this.input){
			System.out.printf("%d, %d, %d\n", building.left, building.right,building.height);
		}
	}
	
	/**
	 * Solves the problem using brute force (without thinking too much)
	 * Complexity is going to be polynomial
	 */
	public void solveBruteForce() {
		this.skyline=new Skyline(this.input.get(0));
		for(int i=1;i<this.input.size();i++){
			Skyline s2 = new Skyline(this.input.get(i));
			this.skyline=new Skyline(this.skyline,s2);
		}
		calculateKeyPoints();
	}
	
	/**
	 * Solves the problem using divide and conquer (thinking a little bit)
	 * Complexity and times are going to be much better
	 */
	public void solveDivideAndConquer() {
		Collections.sort(this.input);
		this.skyline=this.solveDivideAndConquerRecursivo(0,input.size()-1);
		calculateKeyPoints();
	}
	public Skyline solveDivideAndConquerRecursivo(int left, int right){
		if(right>left){
			int center=(left+right)/2;
			Skyline s1=solveDivideAndConquerRecursivo(left,center);
			Skyline s2=solveDivideAndConquerRecursivo(center+1,right);
			return new Skyline(s1,s2);
		}
		else{ //left == right
			return new Skyline(this.input.get(left));
		}
	}
	
	private void calculateKeyPoints(){
		int initialPos=this.skyline.getLeftSide();
		int finalPos=this.skyline.getRightSide();
		int previousHeight=this.skyline.getHeightInPosition(initialPos);
		this.puntosClave.add(new KeyPoint(initialPos, this.skyline.getHeightInPosition((initialPos))));
		for(int i=initialPos+1;i<=finalPos;i++){
			if(this.skyline.getHeightInPosition(i)!=previousHeight){
				this.puntosClave.add(new KeyPoint(i, this.skyline.getHeightInPosition((i))));
				previousHeight=this.skyline.getHeightInPosition(i);
			}
		}
	}
	/**
	 * Prints the final solution (the key points for the generated skyline)
	 */
	public void printSolution() {
		for(KeyPoint k : puntosClave){
			System.out.printf("%d %d\n", k.x, k.y);
		}
	}
	
	/**
	 * Returns the solution for the problem
	 * @return the list of key points for the generated skyline
	 */
	public List<KeyPoint> getSolution() {
		return puntosClave;
	}
}
