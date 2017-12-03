package gp;

public abstract class AbstractFunction implements Node {
	
	Node left,right;
	
	public AbstractFunction(Node left,Node right){
		this.left=left;
		this.right=right;
	}
	
	public double getVal(){
		double a=left.getVal();
		double b=right.getVal();
		return function(a,b);
	}
	
	public abstract double function(double a, double b);
	
}
