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
	
	public abstract Node clone();
	
	@Override
	public String toString(String[] varSymbols){
		return "("+left.toString(varSymbols)+myString()+right.toString(varSymbols)+")";
	}
	
	abstract String myString();

	@Override
	public void updateSize(){
		size=left.getSize()+right.getSize()+1;
		if(root!=null) root.updateSize();
	}
	
	@Override
	public Node find(int i){
		int l=left.getSize();
		if(l>i){
			return left.find(i);
		}
		else if(l<i){
			return right.find(i-l);
		}
		else{
			return this;
		}
	}
	
	@Override
	public void swapNodes(Node child,Node newNode){
		if(left.equals(child)){
			left=newNode.clone();
			left.setRoot(this);
		}
		else{ 
			right=newNode.clone();
			right.setRoot(this);
		}
		updateSize();
	}
	
	public double getVal(double[] paramValues){
		double a=left.getVal(paramValues);
		double b=right.getVal(paramValues);
		return function(a,b);
	}
	
	public abstract double function(double a, double b);
	
}
