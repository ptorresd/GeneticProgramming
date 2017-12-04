package gp;

public class GeneticProgram {
	Node function;
	double fitness;

	static double aditionProb=0.3;
	static double substractionProb=0.2;
	static double multiplicationProb=0.4;
	
	static double operationProb=0.5;
	static double variableProb=0.3;
	static double constantMin=-50;
	static double constantMax=50;
	static double variablesNumber=1;
	
	public GeneticProgram(){
		function=new RootNode(randomFunction(0));
		fitness=Double.POSITIVE_INFINITY;
	}
	
	public GeneticProgram(Node function){
		this.function=function;
		fitness=Double.POSITIVE_INFINITY;
	}
	
	public double evaluateFitness(double[][] input, double[] output){
		fitness=0;
		for(int i=0;i<input.length;i++){
			double res=function.getVal(input[i]);
			fitness+=(res-output[i])*(res-output[i]);
		}
		return fitness;
	}
	
	public double getFiness(){
		return fitness;
	}
	
	public GeneticProgram crossover(Node anotherFunction){
		Node newFunction=function.clone();
		int s1=newFunction.getSize();
		int s2=anotherFunction.getSize();
		int pos1=(int) Math.ceil(Math.random()*s1);
		int pos2=(int) Math.ceil(Math.random()*s2);
		Node nodo1=newFunction.find(pos1);
		Node nodo2=anotherFunction.find(pos2);
		nodo1.getRoot().swapNodes(nodo1, nodo2);
		return new GeneticProgram(newFunction);
	}
	
	public GeneticProgram mutation(){
		Node newFunction=function.clone();
		int s=newFunction.getSize();
		int pos=(int) Math.ceil(Math.random()*s);
		Node nodo=newFunction.find(pos);
		nodo.getRoot().swapNodes(nodo, randomFunction(0));
		return new GeneticProgram(newFunction);
	}
	
	public Node randomFunction(int depth){
		double a=Math.random();
		if(depth>4)a=operationProb+(1-operationProb)*a;
		if(a<operationProb){
			double b=Math.random();
			Node left=randomFunction(depth+1);
			Node right=randomFunction(+1);
			if(b<aditionProb){
				return new AditionNode(left,right);
			}
			if(b<aditionProb+substractionProb){
				return new SubstractionNode(left,right);
			}
			if(b<aditionProb+substractionProb+multiplicationProb){
				return new MultiplicationNode(left,right);
			}
			return new DivisionNode(left,right);
		}
		if(a<operationProb+variableProb){
			int var=(int) Math.floor(Math.random()*variablesNumber);
			return new VariableNode(var);
		}
		else{
			double num=Math.random()*2-1;
			num=num*Math.abs(num)+1;
			num=(constantMax-constantMin)*num+constantMin;
			return new ConstantNode(num);
		}
	}

	public Node getFunction() {
		return function;
	}

	public String toString(String[] varSymbols) {
		return function.toString(varSymbols);
	}

	public double getValue(double[] ds) {
		return function.getVal(ds);
	}
}
