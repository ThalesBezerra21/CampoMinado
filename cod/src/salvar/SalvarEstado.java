package salvar;

import java.io.Serializable;

import jogo.Jogo;

public class SalvarEstado implements Serializable {

	    private Jogo jogo;

	    public SalvarEstado(Jogo jogo) {
	        this.jogo = jogo;
	    }

		public Jogo getJogo() {
			return jogo;
		}
}

