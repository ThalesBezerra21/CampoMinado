package jogo;
import interfaces.Interface;
import exeption.InputInvalidaExeption;
import tabuleiro.Tabuleiro;
import tabuleiro.TabuleiroMaluco;

public class Jogo implements Interface{

	private int dificuldade;
	private int maluquice;
	private int largura;
	private int altura;
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
			this.altura = 8;
		}else if(dificuldade == 1){
			this.largura = 10;
			this.altura = 10;
		}else if(dificuldade == 2){
			this.largura = 12;
			this.altura = 12;
		}else{
			throw new InputInvalidaExeption("Essa dificuladade não existe");
		}
		
		this.tab = new Tabuleiro(largura, altura);
		if (maluquice != 0) {
			try{
				this.tab = new TabuleiroMaluco(largura, altura, this.maluquice);
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
	
	public int getDificuldade() {
		return this.dificuldade;
	}
	
	public int getMaluquice() 
	{
		return this.maluquice;
	}

	public void openCell(int coordX, int coordY) throws InputInvalidaExeption{
		if (tab.isValidLocation(coordX, coordY) && !(this.vitoria || this.perdeu)) {
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
		if (tab.isValidLocation(coordX, coordY) && !(this.vitoria || this.perdeu)) {
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
	
	public int getPontuacao() {
		int pont = 0;
		for(char[] linha: getTabuleiro()) {
			for(char ch: linha) {
				if(Character.isDigit(ch)) {
					pont += (10+this.dificuldade)*Character.getNumericValue(ch);
				}
			}
		}
		return pont;
		
	}
}
