package gp;

public class Sum extends AbstractFunction {

	public Sum(Node left, Node right) {
		super(left, right);
	}

	@Override
	public double function(double a, double b) {
		return a+b;
	}

}
