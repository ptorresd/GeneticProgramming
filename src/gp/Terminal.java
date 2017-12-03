package gp;

public class Terminal extends AbstractNode {
	
	double val;
	
	public Terminal(double val){
		this.val=val;
	}
	
	@Override
	public double getVal(double[] paramValues) {
		return val;
	}


}
