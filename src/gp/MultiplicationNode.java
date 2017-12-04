package gp;

public class MultiplicationNode extends AbstractOperation {

	public MultiplicationNode(Node left, Node right) {
		super(left, right);
	}
	
	@Override
	public Node clone(){
		Node leftClone=left.clone();
		Node rightClone=right.clone();
		return new MultiplicationNode(leftClone,rightClone);
	}
	
	@Override
	public double function(double a, double b) {
		return a*b;
	}
	@Override
	String myString() {
		return "*";
	}
}
