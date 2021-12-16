package ranking;

import java.io.Serializable;

public class SalvarRankingEstado implements Serializable {

	    private Ranking rank;

	    public SalvarRankingEstado(Ranking rank){
	        this.rank = rank;
	    }

		public Ranking getRanking() {
			return rank;
		}
}

