package salvar;

import java.io.Serializable;

import jogo.Jogo;

public class SalveEstado implements Serializable {

	    private Jogo jogo;

	    public SalveEstado(Jogo jogo) {
	        this.jogo = jogo;
	    }

		public Jogo getJogo() {
			return jogo;
		}
}

