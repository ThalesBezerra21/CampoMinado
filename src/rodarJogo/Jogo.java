package campoMinado.rodarJogo;

import java.util.Scanner;

import campoMinado.celulas.*;
import campoMinado.tabuleiro.*;

public class Jogo implements campoMinado.Interface{

	private int dificuladade;
	private int maluquice;
	private Tabuleiro tab;

 	public Jogo() {	
		startGame();
	}

	public void startGame(){
		setMaluco();

		if(this.maluquice < 0 || this.maluquice > 3){
			System.out.println("Jogo interrompido. Esse nivel de maluquice nao existe.");
			return;
		}

		setDificuldade();
		
		int largura;

		if(dificuladade == 1) {
				System.out.println("Jogo iniciando... Nivel facil");
				//this.tab = new TabuleiroMaluco(4, 4, 1);  
				largura = 8;
		}else if(dificuladade == 2){	 
				System.out.println("Jogo iniciando... Nivel medio");
			  	//this.tab = new Tabuleiro(16, 16);
				largura = 12;
		}else if(dificuladade == 3) {		
				System.out.println("Jogo iniciando... Nivel dificil");
				//this.tab = new Tabuleiro(24, 24);
				largura = 16;
		}else{
				System.out.println();
				System.out.println("Jogo interrompido. Esse nivel de dificuladade nao existe.");
				return;
		}	

		if(maluquice == 0){
			this.tab = new Tabuleiro(largura, largura);
		}else{
			this.tab = new TabuleiroMaluco(largura, largura, this.maluquice);
		}

		printCampoMinado();
		choosePlace();		
	}

	public void setDificuldade(){
		Scanner d = new Scanner(System.in);
		System.out.println("Escolha o nivel de dificuladade:     |   1   |   2   |    3    |");
		System.out.println("                                     | Facil | Medio | Dificil |");
		this.dificuladade = d.nextInt();
		//d.close();
	}

	public void setMaluco(){
		Scanner i = new Scanner(System.in);
		System.out.println("Escolha o nivel de maluquice: | 0 | 1 | 2 | 3 |");
		this.maluquice = i.nextInt();
	}


	public void choosePlace() {
		boolean running = true;
		while(running){
		  Scanner l = new Scanner(System.in);
		  System.out.println("Escolha uma linha"); 
		  int coordX = l.nextInt() - 1;
		  //l.close();
		
		  Scanner c = new Scanner(System.in);
		  System.out.println("Escolha uma coluna");
		  int coordY = c.nextInt() - 1;
		  //c.close();

		  System.out.print("\033[H\033[2J");
		  System.out.flush();

      Scanner p = new Scanner(System.in);
			System.out.println("Escolha uma acao");
			System.out.println(" 1 - Abrir ");
			System.out.println(" 2 - Colocar Bandeira");
			int purpose = l.nextInt();
			
			switch (purpose) {
			case 1:
				if (tab.isValidLocation(coordX, coordY)) {
					if((tab.getFlag(coordX, coordY))== true) {
						System.out.println("Voce nao pode abrir celulas com bandeiras!");
					}else {
						tab.openCell(coordX, coordY);
						if(tab.getCell(coordX, coordY) instanceof Bomb){
							System.out.println("Voce perdeu!");
							printCampoMinado();
							running = false;
							break;
						}	
					}
			  }else {
					System.out.println("Escolha um lugar valido");
				}
        		System.out.println();
        		printCampoMinado();
        		System.out.println();
        		break;
			case 2:
				if (tab.isValidLocation(coordX, coordY)) {
					tab.setFlag(coordX, coordY);
          			System.out.println();
					printCampoMinado();
				} else {
					System.out.println("Escolha um lugar valido");
				}
        	break;
      }
		}
	}

	public void printCampoMinado() {
		Cell[][] campoMinado = tab.getTabuleiro();
		System.out.print("    ");
		for(int i = 0; i < campoMinado.length; i++){
		  System.out.print(i+1);
		  System.out.print("  ");
		}
		System.out.println();
		System.out.println();
	
		for (int i = 0; i < campoMinado.length; i++) {
			System.out.print(i+1);
			System.out.print("   ");
			for (int j = 0; j < campoMinado[0].length; j++) {
				System.out.print(campoMinado[i][j].getChar());
				System.out.print("  ");
			}
			System.out.println();
			}
		}

	@Override
	public void setFlag(int coordX, int coordY) {
		tab.setFlag(coordX, coordY);
	}

	@Override
	public void openCell(int coordX, int coordY) {
		tab.openCell(coordX, coordY);
	}
}
