package jogo;
import interfaces.Interface;
import exeption.InputInvalidaExeption;
import tabuleiro.Tabuleiro;
import tabuleiro.TabuleiroMaluco;

public class Jogo implements Interface{

	private int dificuldade;
	private int maluquice;
	private int largura;
	private boolean vitoria;
	private boolean perdeu;
	private Tabuleiro tab;

	public Jogo(int dificuldade,int maluquice) throws InputInvalidaExeption{
		vitoria = false;
		perdeu = false;
		this.maluquice = maluquice;
		this.dificuldade = dificuldade;
		if(dificuldade == 0){
			this.largura = 8;			
		}else if(dificuldade == 1){
			this.largura = 10;
		}else if(dificuldade == 2){
			this.largura = 12;	
		}else{
			throw new InputInvalidaExeption("Essa dificuladade não existe");
		}
		
		this.tab = new Tabuleiro(largura, largura);
		if (maluquice != 0) {
			try{
				this.tab = new TabuleiroMaluco(largura, largura, this.maluquice);
			}catch(InputInvalidaExeption e){
				throw e;
			}
		}
	}
	
	public int getLines() {
		return tab.getLines();
	}
	
	public int getColumns() {
		return tab.getColumns();
	}

	public void openCell(int coordX, int coordY) throws InputInvalidaExeption{
		if (tab.isValidLocation(coordX, coordY)) {
			if ((tab.getFlag(coordX, coordY)) == true) {
				throw new InputInvalidaExeption("Você não pode abrir casas com bandeiras");
			}else{
				tab.openCell(coordX, coordY);
				if (tab.getCell(coordX, coordY).getBomb()) {
					perdeu = true;				
				}else if (tab.checkVitoria()){
					vitoria = true;
				}
			}
		}else{
			throw new InputInvalidaExeption("Casa inválida para abrir");
		}
	}

	public void setFlag(int coordX,int coordY) throws InputInvalidaExeption{
		if (tab.isValidLocation(coordX, coordY)) {
			tab.setFlag(coordX, coordY);	
		}else{
			throw new InputInvalidaExeption("Casa inválida para colocar bandeira");
		}
	}

	public boolean getVitoria(){
		return this.vitoria;
	}

	public boolean getPerdeu(){
		return this.perdeu;
	}

	public char[][] getTabuleiro(){
		int lines = tab.getLines(), columns = tab.getColumns();
		char[][] tabuleiro = new char[lines][columns];
		for(int i = 0; i < lines; i++){
			for(int j = 0; j < columns; j++) {
				tabuleiro[i][j] = tab.getCell(i, j).getChar(); 
			}
		}
		return tabuleiro;
	}
}
