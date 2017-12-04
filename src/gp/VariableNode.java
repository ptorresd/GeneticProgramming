package gp;

public class VariableNode extends AbstractTerminal {
	
	int parameterIndex;
	
	public VariableNode(int index){
		this.parameterIndex=index;
	}
	
	@Override
	public double getVal(double[] paramValues) {
		return paramValues[parameterIndex];
	}

	@Override
	public Node clone() {
		return new VariableNode(this.parameterIndex);
	}

	@Override
	public String toString(String[] varSymbols) {
		return varSymbols[parameterIndex];
	}

	


}
