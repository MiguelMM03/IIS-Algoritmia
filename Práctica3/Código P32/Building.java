package alg.p32;

public class Building implements Comparable<Building> {
	int left;
	int right;
	int height;
	
	public Building(int left, int right, int height) {
		this.left = left;
		this.right = right;
		this.height = height;
	}
	
	public int compareTo(Building otherBuilding) {
		return this.right - otherBuilding.right;
	}
}
