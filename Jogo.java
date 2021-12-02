package campoMinado.rodarJogo;

public class Jogo{

	private int dificuldade;
	private int maluquice;
	private int coordX;
	private int coordY;
	private InterfaceGrafica ig;

 	public Jogo(){	
	}

	public Jogo(int dificuldade,int maluquice){
		setMaluco(this.maluquice);
		//if(this.maluquice < 0 || this.maluquice > 3){
			//System.out.println("Jogo interrompido. Esse nivel de maluquice nao existe.");
			//return;
		//}
		setDificuldade(this.dificuldade);
		ig.printCampoMinado();
		choosePlace(coordX, coordY);	
	}

	public void setDificuldade(int dificuldade){
		this.dificuldade = dificuldade;
	}

	public void setMaluco(int maluquice){
		this.maluquice = maluquice;
	}


	public void choosePlace(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;	
	}
}
