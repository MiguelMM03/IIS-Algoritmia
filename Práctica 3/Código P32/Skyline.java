package alg.p32;

import java.util.HashMap;
import java.util.Map;

public class Skyline {
	private Map<Integer, Integer> heightInPosition = new HashMap<Integer, Integer>(); //key = position; value = height; that is, it stores the height in a particular position of the skyline
	private int leftSide; //left side of the skyline (first point of the skyline)
	private int rightSide; //right side of the skyline (last poaint of the skyline)
	
	/**
	 * Creates a new skyline from scratch
	 * @param building the only building used to create the skyline
	 */
	public Skyline(Building building) {
		this.leftSide=building.left;
		this.rightSide=building.right;
		for(int i=building.left;i<building.right;i++){
			this.heightInPosition.put(i,building.height);
		}
		this.heightInPosition.put(building.right,0);
	}
	
	/**
	 * Creates a new skyline joining together other 2 previous skylines
	 * @param s1 one of the skylines
	 * @param s2 the other of the skylines
	 */
	public Skyline(Skyline s1, Skyline s2) {
		this.leftSide=(s1.leftSide>s2.leftSide)?s2.leftSide:s1.leftSide;
		this.rightSide=(s1.rightSide>s2.rightSide)?s1.rightSide:s2.rightSide;
		for(int i=this.leftSide;i<=this.rightSide;i++){
			int height1=s1.getHeightInPosition(i);
			int height2=s2.getHeightInPosition(i);
			int height=(height1>height2)?height1:height2;
			heightInPosition.put(i,height);
		}
	}
	
	/**
	 * Gets the height in a specific position
	 * @param position the position in the skyline
	 * @return the height in the skyline
	 */
	public int getHeightInPosition(int position) {
		if (this.heightInPosition.containsKey(position))
			return this.heightInPosition.get(position);
		return 0;
	}
	
	/**
	 * Returns the first position of the skyline
	 * @return the first position of the skyline
	 */
	public int getLeftSide() {
		return this.leftSide;
	}
	
	/**
	 * Returns the last position of the skyline
	 * @return the last position of the skyline
	 */
	public int getRightSide() {
		return this.rightSide;
	}
	
	/**
	 * Prints the skyline, that is, the height in each of the positions of the skyline
	 */
	public void printHeights() {
		for (int i = this.leftSide; i <= this.rightSide; i++) {
			System.out.printf("%3d", this.heightInPosition.get(i));
		}
		System.out.println();
	}
	
}
