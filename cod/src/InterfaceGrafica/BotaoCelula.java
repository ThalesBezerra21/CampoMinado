package InterfaceGrafica;

import exeption.InputInvalidaExeption;
import jogo.Jogo;
import processing.core.*;

public class BotaoCelula extends Botao{
	private PApplet app;
	private TelaMestre telaMestre;
	private Jogo jogo;
	private int locXTab;
	private int locYTab;
	private PImage bandeiraImg;
	private PImage bombaImg;
	
	public BotaoCelula(PApplet app, TelaMestre telaMestre, int coordX, int coordY, int largura, int locXTab, int locYTab, Jogo jogo, PImage bombaImg, PImage bandeiraImg){
		super(app, coordX, coordY, largura, largura, "");
		this.app = app;
		this.telaMestre = telaMestre;
		this.jogo = jogo;
		this.locXTab = locXTab;
		this.locYTab = locYTab;
		this.bandeiraImg = bandeiraImg;
		this.bombaImg = bombaImg;
	} 
	
	public void draw() {
		int coordX = this.getCoordX();
		int coordY = this.getCoordY();
		int largura = this.getLargura();
		
		char nome = jogo.getTabuleiro()[this.locXTab][this.locYTab];
		this.setNome(nome);
		app.textSize(25);
		if(nome == '-' || nome == 'P') {
			if(this.over()) {
				app.fill(app.color(107,112,92));
			}else {
				app.fill(app.color(165,165,141));
			}
			app.rect(coordX, coordY, largura, largura);
			if(nome == 'P') {
				app.imageMode(app.CENTER);
				app.image(bandeiraImg, coordX, coordY);
			}
		}else{
			app.fill(app.color(155, 155, 155));
			app.rect(coordX, coordY, largura, largura);
			colorNumber(nome);
			app.text(nome, coordX, coordY);
			if(nome == '*') {
				app.imageMode(app.CENTER);
				app.image(this.bombaImg, coordX, coordY);
			}
		}
	}
	
	private void colorNumber(char label) {
		PApplet app = this.getApp();
		switch(label) {
			case '1':
				app.fill(app.color(32,64,255));
				break;
			case '2':
				app.fill(app.color(35,255,20));
				break;
			case '3':
				app.fill(app.color(237, 28, 33));
				break;
			case '*':
				break;
			default:
				app.fill(app.color(120, 81, 169));
				break;
		}
	}
	
	public void click(boolean isBandeira) {
		if(this.over()) {
			try{
				if(isBandeira) {
					jogo.setFlag(this.locXTab, this.locYTab);
					telaMestre.playEffect("data/tuc.mp3");
				}else {
					jogo.openCell(this.locXTab, this.locYTab);
					telaMestre.playEffect("data/shot2.mp3");
				}
			}catch(InputInvalidaExeption e) {
				System.out.println("Célula inválida");
			}
		}
	}

	public int getLocXTab() {
		return locXTab;
	}

	public void setLocXTab(int locXTab) {
		this.locXTab = locXTab;
	}

	public int getLocYTab() {
		return locYTab;
	}

	public void setLocYTab(int locYTab) {
		this.locYTab = locYTab;
	}

}

