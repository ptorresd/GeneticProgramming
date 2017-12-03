package gp;

public class Substraction extends AbstractFunction {

	public Substraction(Node left, Node right) {
		super(left, right);
	}

	@Override
	public double function(double a, double b) {
		return a-b;
	}

}
