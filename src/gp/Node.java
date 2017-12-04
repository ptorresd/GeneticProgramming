package gp;

public interface Node{
	
	Node find(int i);
	
	Node clone();
	
	Node getRoot();
	
	void setRoot(Node root);
	
	double getVal(double[] paramValues);
	
	void updateSize();
	
	int getSize();
	
	void swapNodes(Node child, Node newNode);
	
	String toString(String[] varSymbols);
}
