package rodarJogo;

public class SaveGame {
    
private Jogo jogo;

public SaveGame(Jogo jogo){    
    jogo = InterfaceGrafica.getJogo();
}

public Jogo LoadGame(){
    return jogo;
}

}
