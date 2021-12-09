package InterfaceGrafica;

import exeption.InputInvalidaExeption;
import jogo.Jogo;
import processing.core.*;

public class BotaoCelula extends Botao{
	public PApplet app;
	public Jogo jogo;
	public int coordX;
	public int coordY;
	public int locXTab;
	public int locYTab;
	public int largura;
	
	public BotaoCelula(PApplet app, int coordX, int coordY, int largura, int locXTab, int locYTab, Jogo jogo){
		super(app, coordX, coordY, largura, largura, "");
		this.jogo = jogo;
	} 
	
	public void draw() {
		this.setNome(jogo.getTabuleiro()[locXTab][locYTab]);
		super.draw();
	}
	
	public void click() {
		if(this.over()) {
			try {
				jogo.openCell(locXTab, locYTab);
			}catch(InputInvalidaExeption e) {
				System.out.println("Célula inválida");
			}
		}
	}

}

