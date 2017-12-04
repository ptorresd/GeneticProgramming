package gp;

public class AditionNode extends AbstractOperation {

	public AditionNode(Node left, Node right) {
		super(left, right);
	}
	@Override
	public Node clone(){
		Node leftClone=left.clone();
		Node rightClone=right.clone();
		return new AditionNode(leftClone,rightClone);
	}
	@Override
	public double function(double a, double b) {
		return a+b;
	}
	@Override
	String myString() {
		return "+";
	}

}
