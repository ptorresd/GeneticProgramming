package gp;

public class DivisionNode extends AbstractOperation {

	public DivisionNode(Node left, Node right) {
		super(left, right);
	}
	
	@Override
	public Node clone(){
		Node leftClone=left.clone();
		Node rightClone=right.clone();
		return new DivisionNode(leftClone,rightClone);
	}
	
	@Override
	public double function(double a, double b) {
		if(b==0) return Double.POSITIVE_INFINITY;
		return a/b;
	}
	@Override
	String myString() {
		return "/";
	}
}
