package alg.p7;


public class Node implements Comparable<Node> {
    protected int indice;
    protected int coste; 

	public Node(int indice, int coste) {
    	this.indice = indice; 
    	this.coste=coste;
	}
	public int getCoste() { return coste; }
	

    public int getIndice() {
    	return indice;
    }

    
	@Override
	public int compareTo(Node node) {
		int totalValue = getCoste();
		int totalValueToBeCompared = node.getCoste();
		
		if (totalValue > totalValueToBeCompared) return 1;
		else if (totalValue == totalValueToBeCompared) return 0; 
		else return -1; 
	}
}
