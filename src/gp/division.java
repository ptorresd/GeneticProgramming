package gp;

public class division extends AbstractFunction {

	public division(Node left, Node right) {
		super(left, right);
	}

	@Override
	public double function(double a, double b) {
		return a/b;
	}

}