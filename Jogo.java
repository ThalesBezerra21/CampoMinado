import java.util.Scanner;

public class Jogo {
	
  public Jogo() {	
		int escolha = 0;
		while(escolha < 5){
			startGame();
			escolha++;
		}
	}

	public static void choosePlace(Tabuleiro tab) {
		Scanner l = new Scanner(System.in);
		System.out.println("Choose a line: ");
		int line = l.nextInt();
		
		Scanner c = new Scanner(System.in);
		System.out.println("Choose a column: ");
		int column = c.nextInt();
		
		tab.openCell(line, column);
		tab.printCampoMinado();
	}
		
	public static void startGame(){
	
		Scanner d = new Scanner(System.in);
		System.out.println("Choose the difficulty level:     |  1   |   2    |  3   |  ");
		System.out.print("                                 | Easy | Medium | Hard |  ");
		int dificult = d.nextInt();
		
		if(dificult == 1) {
				System.out.println("Game mode set easy!");
				Tabuleiro tab = new Tabuleiro(8, 8);  
				tab.printCampoMinado();
				choosePlace(tab);
		}else if(dificult == 2){	 
				System.out.println("Game mode set medium!");
			  	Tabuleiro tab = new Tabuleiro(16, 16);
			  	tab.printCampoMinado();
			  	choosePlace(tab);
		}else if(dificult == 3) {		
				System.out.println("Game mode set hard!");
				Tabuleiro tab = new Tabuleiro(24, 24);
				tab.printCampoMinado();
				choosePlace(tab);
		}else{
				System.out.println();
				System.out.println("This level does not exist! Try again.");
				}			
	}
}


// Tabuleiro tab = new Tabuleiro(8, 8);
// tab.printCampoMinado();

// System.out.println();

// tab.setFlag(5, 5, true);
// tab.printCampoMinado();

// System.out.println();

// tab.openCell(4, 3);
// tab.printCampoMinado();
