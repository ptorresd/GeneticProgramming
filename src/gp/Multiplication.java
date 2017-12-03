package gp;

public class Multiplication extends AbstractFunction {

	public Multiplication(Node left, Node right) {
		super(left, right);
	}

	@Override
	public double function(double a, double b) {
		return a*b;
	}

}
