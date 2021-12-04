package rodarJogo;
import java.util.Scanner;
import exeption.*;
import celulas.Cell;

public class InterfaceGrafica implements Interface{

	private int dificuldade;
	private int maluquice;
	private Jogo jogo;

	public InterfaceGrafica() {
		setMaluco();
		setDificuldade();
		startGame();
	}

	public void startGame() {

		if (dificuldade == 1) {
			System.out.println("Jogo iniciando... Nivel facil");
		} else if (dificuldade == 2) {
			System.out.println("Jogo iniciando... Nivel medio");
		} else if (dificuldade == 3) {
			System.out.println("Jogo iniciando... Nivel dificil");
		} 
		try{
			jogo = new Jogo(this.dificuldade, this.maluquice);
		}catch(InputInvalidaExeption e){
			System.out.println("Erro: insira dados validos de dificulade e maluquice");
			return;
		}
		printCampoMinado();
		choosePlace();
	}

	public int setDificuldade() {
		Scanner d = new Scanner(System.in);
		System.out.println("Escolha o nivel de dificuladade:     |   1   |   2   |    3    |");
		System.out.println("                                     | Facil | Medio | Dificil |");
		this.dificuldade = d.nextInt();
		return dificuldade;
	}

	public int setMaluco() {
		Scanner i = new Scanner(System.in);
		System.out.println("Escolha o nivel de maluquice: | 0 | 1 | 2 | 3 |");
		this.maluquice = i.nextInt();
		return maluquice;
	}

	public void choosePlace() {
		boolean running = true;
		while (running) {
			Scanner l = new Scanner(System.in);
			System.out.println("Escolha uma linha");
			int coordX = l.nextInt() - 1;
			// l.close();

			Scanner c = new Scanner(System.in);
			System.out.println("Escolha uma coluna");
			int coordY = c.nextInt() - 1;
			// c.close();

			System.out.print("\033[H\033[2J");
			System.out.flush();

			Scanner p = new Scanner(System.in);
			System.out.println("Escolha uma acao");
			System.out.println(" 1 - Abrir ");
			System.out.println(" 2 - Colocar Bandeira");
			int purpose = l.nextInt();

			switch (purpose) {
			case 1:
				openCell(coordX, coordY);
				break;
			case 2:
				setFlag(coordX, coordY);
				break;
			}
			if(jogo.getPerdeu()){
				System.out.println("Voce perdeu");
				running = false;
			}else if(jogo.getVitoria()){
				System.out.println("Parabens, voce venceu!");
				running = false;
			}

		}
	}
	
	public void openCell(int coordX, int coordY){
		try{
			jogo.openCell(coordX, coordY);
		}catch(InputInvalidaExeption e){
			System.out.println("Essa célula é inválida.");
		}
		printCampoMinado();
	}

	public void setFlag(int coordX,int coordY){
		try{
			jogo.setFlag(coordX, coordY);
		}catch(InputInvalidaExeption e){
			System.out.println("Essa célula é inválida.");
		}
		printCampoMinado();
	}

	public void printCampoMinado() {
		Cell[][] campoMinado = jogo.getTabuleiro().getTabuleiro();
		System.out.print("    ");
		for (int i = 0; i < campoMinado.length; i++) {
			System.out.print(i + 1);
			System.out.print("  ");
		}
		System.out.println();
		System.out.println();

		for (int i = 0; i < campoMinado.length; i++) {
			System.out.print(i + 1);
			System.out.print("   ");
			for (int j = 0; j < campoMinado[0].length; j++) {
				System.out.print(campoMinado[i][j].getChar());
				System.out.print("  ");
			}
			System.out.println();
		}
	}

}
