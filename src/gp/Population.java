package gp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Population {
	ArrayList<GeneticProgram> population;
	int popSize;
	

	public Population(int popSize){
		this.popSize=popSize;
		population=new ArrayList<>();
		while(population.size()<popSize){
			population.add(new GeneticProgram());
		}
	}
	

	public void setPopulation(ArrayList<GeneticProgram> population) {
		this.population = population;
	}
	
	void evaluateFitness(double[][] input, double[] output){
		for(GeneticProgram gp:population){
			gp.evaluateFitness(input, output);
		}
	}
	
	ArrayList<GeneticProgram> naturalSelection(){
		Comparator<GeneticProgram> comp=new FitnessComparator();
		PriorityQueue<GeneticProgram> selection=new PriorityQueue<>(popSize,comp);
		for(GeneticProgram gp:population){
			selection.add(gp);
		}
		ArrayList<GeneticProgram> survivors=new ArrayList<>();
		
		while(survivors.size()<50) survivors.add(selection.remove());
		return survivors;
	}
	
	GeneticProgram tournamentSelection(){
		int n=(int) Math.ceil(Math.random()*popSize/30)+(popSize/30);
		Comparator<GeneticProgram> comp=new FitnessComparator();
		PriorityQueue<GeneticProgram> selection=new PriorityQueue<>(n,comp);
		for(int i=0;i<n;i++){
			int r=(int) Math.floor(Math.random()*popSize);
			selection.add(population.get(r));
		}
		return selection.remove();
	}
	
	ArrayList<GeneticProgram> newGeneration(){
		ArrayList<GeneticProgram> newGen=naturalSelection();
		while(newGen.size()<popSize){
			if(Math.random()<0.02){
				GeneticProgram gp = tournamentSelection();
				GeneticProgram gp2=gp.mutation();
					if(gp2.getFunction().getSize()<129)newGen.add(gp2);
			}
			else{
				GeneticProgram gp1 = tournamentSelection();
				GeneticProgram gp2 = tournamentSelection();
				GeneticProgram gp3=gp1.crossover(gp2.getFunction());
				if(gp3.getFunction().getSize()<129)newGen.add(gp3);
			}
		}
		return newGen;
	}
	
	public void epoch(double[][] input, double[] output){
		evaluateFitness(input,output);
		population=newGeneration();
	}
	public GeneticProgram getBest(){
		Comparator<GeneticProgram> comp=new FitnessComparator();
		PriorityQueue<GeneticProgram> selection=new PriorityQueue<>(popSize,comp);
		for(GeneticProgram gp:population){
			selection.add(gp);
		}
		return selection.remove();
	}
	
}
