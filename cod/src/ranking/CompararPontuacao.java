package ranking;

import java.util.Comparator;

public class CompararPontuacao{
	
	public int compareTo(Pessoa p1, Pessoa p2) { 
		if (p1.getPontuacao() > p2.getPontuacao()) { 
			return -1; 
		} if (p1.getPontuacao() < p2.getPontuacao()) { 
			return 1; 
		}
		return 0; 
 }
}
  