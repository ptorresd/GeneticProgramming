package gp;

public class Parameter extends AbstractNode {
	
	int parameterIndex;
	
	public Parameter(int index){
		this.parameterIndex=index;
	}
	
	@Override
	public double getVal(double[] paramValues) {
		return paramValues[parameterIndex];
	}


}
