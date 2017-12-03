package gp;

public abstract class AbstractOperation extends AbstractNode {
	
	Node left,right;
	
	public AbstractOperation(Node left,Node right){
		root=null;
		this.left=left;
		left.setRoot(this);
		this.right=right;
		right.setRoot(this);
		size=left.getSize()+right.getSize()+1;	
	}
	
	@Override
	public void updateSize(){
		size=left.getSize()+right.getSize()+1;
		if(root!=null) root.updateSize();
	}
	
	public double getVal(double[] paramValues){
		double a=left.getVal(paramValues);
		double b=right.getVal(paramValues);
		return function(a,b);
	}
	
	public abstract double function(double a, double b);
	
}
