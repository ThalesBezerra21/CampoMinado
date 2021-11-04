import java.util.Scanner;

public class Jogo {

	public Jogo() {
		int escolha = 0;
		while (escolha < 5) {
			startGame();
			escolha++;
		}
	}

	public static void choosePlace(Tabuleiro tab) {
		while (true) {
			Scanner l = new Scanner(System.in);
			System.out.println("Choose a line: ");
			int line = l.nextInt();

			Scanner c = new Scanner(System.in);
			System.out.println("Choose a column: ");
			int column = c.nextInt();
			// System.out.println(tab.getLine());
			// System.out.println(tab.getColum());
			
			Scanner p = new Scanner(System.in);
			System.out.println("Select your purpose: ");
			System.out.println(" 1 - Open Cell ");
			System.out.println(" 2 - Set Flag");
			int purpose = l.nextInt();
			
			switch (purpose) {
			case 1:
				if (line < tab.getLine() && column < tab.getColum()) {
					tab.openCell(line, column);
					tab.printCampoMinado();
				} else {
					System.out.println("Choose a valid place");
				}
			case 2:
				if (line < tab.getLine() && column < tab.getColum()) {
					tab.setFlag(line, column, true);
					tab.printCampoMinado();
				} else {
					System.out.println("Choose a valid place");
				}
			}
		}
	}

	public static void startGame() {

		Scanner d = new Scanner(System.in);
		System.out.println("Choose the difficulty level:     |  1   |   2    |  3   |  ");
		System.out.print("                                 | Easy | Medium | Hard |  ");
		int dificult = d.nextInt();

		if (dificult == 1) {
			System.out.println("Game mode set easy!");
			Tabuleiro tab = new Tabuleiro(8, 8);
			tab.printCampoMinado();
			choosePlace(tab);
		} else if (dificult == 2) {
			System.out.println("Game mode set medium!");
			Tabuleiro tab = new Tabuleiro(16, 16);
			tab.printCampoMinado();
			choosePlace(tab);
		} else if (dificult == 3) {
			System.out.println("Game mode set hard!");
			Tabuleiro tab = new Tabuleiro(24, 24);
			tab.printCampoMinado();
			choosePlace(tab);
		} else {
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