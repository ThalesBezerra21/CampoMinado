package rodarJogo;

import java.util.Scanner;

import campoMinado.celulas.*;
import campoMinado.tabuleiro.*;

public class Jogo {

	private int dificuladade;
	private Tabuleiro tab;

 	public Jogo() {	
		startGame();
	}

	public void startGame(){
		setDificuldade();
		
		if(dificuladade == 1) {
				System.out.println("Game mode set testando5!");
				this.tab = new TabuleiroMaluco(8, 8, 3);  
		}else if(dificuladade == 2){	 
				System.out.println("Game mode set medium!");
			  	this.tab = new Tabuleiro(16, 16);
		}else if(dificuladade == 3) {		
				System.out.println("Game mode set hard!");
				this.tab = new Tabuleiro(24, 24);
		}else{
				System.out.println();
				System.out.println("This level does not exist! Try again.");
				return;
		}	
		printCampoMinado();
		choosePlace();		
	}

	public void setDificuldade(){
		Scanner d = new Scanner(System.in);
		System.out.println("Choose the difficulty level:     |  1   |   2    |  3   |  ");
		System.out.print("                                 | Easy | Medium | Hard |  ");
		this.dificuladade = d.nextInt();
		//d.close();
	}


	public void choosePlace() {
		boolean running = true;
		while(running){
		  Scanner l = new Scanner(System.in);
		  System.out.println("Choose a line: "); 
		  int coordX = l.nextInt() - 1;
		  //l.close();
		
		  Scanner c = new Scanner(System.in);
		  System.out.println("Choose a column: ");
		  int coordY = c.nextInt() - 1;
		  //c.close();

		  System.out.print("\033[H\033[2J");
		  System.out.flush();

      Scanner p = new Scanner(System.in);
			System.out.println("Select your purpose: ");
			System.out.println(" 1 - Open Cell ");
			System.out.println(" 2 - Set Flag");
			int purpose = l.nextInt();
			
			switch (purpose) {
			case 1:
				if (tab.isValidLocation(coordX, coordY)) {
					if((tab.getFlag(coordX, coordY))== true) {
						System.out.println("In this place there is a flag, and it cannot be opened");
					}else {
						tab.openCell(coordX, coordY);
						if(tab.getCell(coordX, coordY) instanceof Bomb){
							System.out.println("Voc� perdeu!");
							printCampoMinado();
							running = false;
							break;
						}	
					}
			  }else {
					System.out.println("Choose a valid place");
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
					System.out.println("Choose a valid place");
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
}
