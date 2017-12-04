package gp;

public class Main {
	public static void main(String[] args){
		Population pop=new Population(500);
		int range=101;
		int start=-50;
		double[][] input=new double[range][1];
		double[] output=new double[range];
		
		for(int i=0;i<range;i++){
			input[i][0]=i+start;
			output[i]=function(i+start);
		}
		System.out.println("Error:");
		for(int i=0;i<50;i++){
			pop.evaluateFitness(input,output);
			System.out.print(pop.getBest().getFiness()+" ");
			pop.setPopulation(pop.newGeneration());
		}
		System.out.println("");
		System.out.println("Resultados:");
		GeneticProgram best=pop.getBest();
		for(int i=0;i<range;i++){
			System.out.print(input[i][0]+" ");
		}
		System.out.println("");
		for(int i=0;i<range;i++){
			System.out.print(output[i]+" ");
		}
		System.out.println("");
		for(int i=0;i<range;i++){
			System.out.print(best.getValue(input[i])+" ");
		}
		System.out.println("");
		String[] s= {"x"};
		System.out.println(pop.getBest().toString(s));
	}
	static double function(double x){
		return x*x*x-37*x*x+20*x+1;
	}
}
