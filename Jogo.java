import java.util.Scanner;

public class Jogo {
	
  public Jogo() {	
		startGame();
	}

	public void startGame(){
	
		Scanner d = new Scanner(System.in);
		System.out.println("Choose the difficulty level:     |  1   |   2    |  3   |  ");
		System.out.print("                                 | Easy | Medium | Hard |  ");
		int dificult = d.nextInt();
		Tabuleiro tab;
		//d.close();
		
		if(dificult == 1) {
				System.out.println("Game mode set easy!");
				tab = new Tabuleiro(8, 8);  
		}else if(dificult == 2){	 
				System.out.println("Game mode set medium!");
			  	tab = new Tabuleiro(16, 16);
		}else if(dificult == 3) {		
				System.out.println("Game mode set hard!");
				tab = new Tabuleiro(24, 24);
		}else{
				System.out.println();
				System.out.println("This level does not exist! Try again.");
				return;
		}	
		tab.fillTabuleiro();
		tab.printCampoMinado();
		choosePlace(tab);		
	}

	public void choosePlace(Tabuleiro tab) {
		while(true){
		  System.out.println("Choose a line: ");
		  Scanner l = new Scanner(System.in);
		  int line = l.nextInt() - 1;
		
		  System.out.println("Choose a column: ");
		  Scanner c = new Scanner(System.in);
		  int column = c.nextInt() - 1;

		  System.out.print("\033[H\033[2J");
		  System.out.flush();

      Scanner p = new Scanner(System.in);
			System.out.println("Select your purpose: ");
			System.out.println(" 1 - Open Cell ");
			System.out.println(" 2 - Set Flag");
			int purpose = l.nextInt();
			
			switch (purpose) {
			case 1:
				if (line < tab.getLine() && column < tab.getColum()) {
					tab.openCell(line, column);
					if(Cell.getFlag() == true) {
						System.out.println("In this place there is a flag, and it cannot be opened");
						tab.openCell(line, column);
					}else {
					tab.openCell(line, column);	
					}

			  }else {
					System.out.println("Choose a valid place");
				}
        System.out.println();
        tab.printCampoMinado();
        System.out.println();
        break;
        
			case 2:
				if (line < tab.getLine() && column < tab.getColum()) {
					tab.setFlag(line, column, true);
          System.out.println();
					tab.printCampoMinado();
				} else {
					System.out.println("Choose a valid place");
				}
        break;
      }
		 // tab.openCell(line, column);
		 // tab.printCampoMinado();
		  if(tab.getCell(line, column) instanceof Bomb){
			  System.out.println("Você perdeu!");
			  break;
		  }
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
