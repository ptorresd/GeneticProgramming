package gp;

import java.util.Comparator;

public class FitnessComparator implements Comparator<GeneticProgram> {

	@Override
	public int compare(GeneticProgram gp1, GeneticProgram gp2) {
		return gp1.getFiness()<gp2.getFiness()?-1:1;
	}

}
