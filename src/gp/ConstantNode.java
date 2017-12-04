package gp;

public class ConstantNode extends AbstractTerminal {
	
	double val;
	
	public ConstantNode(double val){
		this.val=val;
	}
	
	@Override
	public double getVal(double[] paramValues) {
		return val;
	}

	@Override
	public Node clone() {
		return new ConstantNode(val);
	}

	@Override
	public String toString(String[] varSymbols) {
		return Double.toString(val);
	}
	

}
