package salvar;

import jogo.Jogo;

public class SaveGame {
    
private Jogo jogo;

public SaveGame(Jogo jogo){    
    //jogo = InterfaceGrafica.getJogo();
	jogo = null;
}

public Jogo LoadGame(){
    return jogo;
}

}
