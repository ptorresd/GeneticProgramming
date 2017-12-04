package gp;

public class SubstractionNode extends AbstractOperation {

	public SubstractionNode(Node left, Node right) {
		super(left, right);
	}
	@Override
	public Node clone(){
		Node leftClone=left.clone();
		Node rightClone=right.clone();
		return new SubstractionNode(leftClone,rightClone);
	}
	
	@Override
	public double function(double a, double b) {
		return a-b;
	}
	@Override
	String myString() {
		return "-";
	}
}
