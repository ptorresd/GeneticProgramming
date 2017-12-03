package gp;

public interface Node {
	double getVal(double[] paramValues);
	void updateSize();
	int getSize();
	void setRoot(Node root);
}
