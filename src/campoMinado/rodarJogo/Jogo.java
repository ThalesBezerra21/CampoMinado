package campoMinado.rodarJogo;

import campoMinado.tabuleiro.Tabuleiro;
import campoMinado.tabuleiro.TabuleiroMaluco;

public class Jogo implements campoMinado.Interface{

	private int dificuldade;
	private int maluquice;
	private int largura;
	private boolean vitoria;
	private boolean perdeu;
	private Tabuleiro tab;

	public Jogo(int dificuldade,int maluquice){
		
		vitoria = false;
		perdeu = false;
		setMaluco(this.maluquice);
		setDificuldade(this.dificuldade);
		if(dificuldade == 1){
			this.largura = 8;			
		}else if(dificuldade == 2){
			this.largura = 12;
		}else if(dificuldade == 3){
			this.largura = 16;	
		}else{}
		
		
		this.tab = new Tabuleiro(largura, largura);

		if (maluquice != 0) {
			this.tab = new TabuleiroMaluco(largura, largura, this.maluquice);
		}
	}

	public void setDificuldade(int dificuldade){
		this.dificuldade = dificuldade;
	}

	public void setMaluco(int maluquice){
		this.maluquice = maluquice;
	}

	public void openCell(int coordX, int coordY){
		if (tab.isValidLocation(coordX, coordY)) {
			if ((tab.getFlag(coordX, coordY)) == true) {
				//System.out.println("Voce nao pode abrir celulas com bandeiras!");
			} else {
				tab.openCell(coordX, coordY);
				if (tab.getCell(coordX, coordY).getBomb()) {
					perdeu = true;
					//System.out.println("Voce perdeu!");					
				}
			}
		} else {
			//System.out.println("Escolha um lugar valido");
		}
	}

	public void setFlag(int coordX,int coordY){
		if (tab.isValidLocation(coordX, coordY)) {
			tab.setFlag(coordX, coordY);	
		}
	}

	public boolean getVitoria(){
		return this.vitoria;
	}

	public boolean getPerdeu(){
		return this.perdeu;
	}

	public Tabuleiro getTabuleiro(){
		return tab;
	}
}
