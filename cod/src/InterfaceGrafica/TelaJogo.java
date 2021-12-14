package InterfaceGrafica;
import jogo.Jogo;
import processing.core.*;
import salvar.SaveJogo;

import java.util.concurrent.TimeUnit;


public class TelaJogo {
	private PApplet app;
	private TelaMestre telaMestre;
	private Jogo jogo;
	private BotaoCelula celulas[][];
	private Botao salvar;
	private Botao desistir;
	private Botao colocarBandeira;
	private int dificuldade;
	private int distorcao;
	private boolean isBandeira;
	private PImage bandeiraImg;
	private PImage bombaImg;
	private int pontuacao = 0;
	private int gameOver = 0;
	private int timerGameOver = 0, timerComecoJogo;
	private boolean primeiroRound = true;
	
	public TelaJogo(PApplet app, TelaMestre telaMestre) {
		this.app = app;
		this.jogo = telaMestre.getJogo();
		this.telaMestre = telaMestre;
		this.dificuldade = jogo.getDificuldade();
		this.distorcao = jogo.getMaluquice();
		this.celulas = new BotaoCelula[jogo.getLines()][jogo.getColumns()];
		this.isBandeira = false;
		int largura = 40;
		
		this.bandeiraImg = app.loadImage("flag.png");
		this.bandeiraImg.resize(largura-5, largura-5);
		
		this.bombaImg = app.loadImage("bomb.png");
		this.bombaImg.resize(largura-5, largura-5);
		
		for(int i = 0; i < jogo.getLines(); i++) {
			for(int j = 0; j < jogo.getColumns(); j++) {
				this.celulas[i][j] = new BotaoCelula(app, telaMestre, (app.width/2-largura*jogo.getColumns()/2)+i*(largura+1), (app.height/2-largura*jogo.getColumns()/2)+j*(largura+1)-app.height/12, largura, i, j, jogo, bombaImg, bandeiraImg);
			}
		}
		desistir = new Botao(app, app.width/2+105, app.height-70, 200, 50, "Desistir");
		salvar = new Botao(app, app.width/2-105, app.height-70, 200, 50, "Salvar e sair");
		colocarBandeira = new Botao(app, app.width/2, app.height-130, 410, 50, "Bandeira");
		
		bandeiraImg = app.loadImage("flag.png");
		bandeiraImg.resize(40, 40);
		
		//this.timerComecoJogo = app.millis();
	}
	
	public void draw() {
		
		this.pontuacao = jogo.getPontuacao();
		
		telaMestre.drawCorDeFundo();
		
		app.fill(app.color(255,255,255));
		app.textSize(25);
		
		for(BotaoCelula[] linhaCelulas: celulas) {
			for(BotaoCelula celula: linhaCelulas) {
				celula.draw();
			}
		}
		salvar.draw();
		desistir.draw();
		colocarBandeira.draw();
		
		//if(this.primeiroRound) {
			//if(app.millis() - this.timerComecoJogo > 1000) {
				//jogo.openCell(jogo.getLines()/2, jogo.getColumns()/2);
				//this.primeiroRound = false;
			//}
		//}
		
		if(jogo.getPerdeu() || jogo.getVitoria()) {
			if(gameOver == 1) {
				timerGameOver = app.millis();
				gameOver = 2;
			}else if (gameOver == 0){
				gameOver = 1;
			}else if(gameOver == 2) {
				if(app.millis() - timerGameOver >= 2000) {
					if(jogo.getVitoria()) {
						telaMestre.changeEstado("Vitoria");
					}else {
						telaMestre.changeEstado("Derrota");
					}
				}
			}
		}
		
		app.textSize(25);
		app.text("Pontuação: " + this.pontuacao, app.width/2, 30);
	}
	
	public void mouse() {
		if(this.gameOver == 0) {
			if(desistir.over()) {
				telaMestre.changeEstado("Inicial");
				desativarBandeira();
			
			}else if(salvar.over()) {
				SaveJogo sg = new SaveJogo(jogo);
				telaMestre.changeEstado("Inicial");
				desativarBandeira();
			
			}else if(colocarBandeira.over()){
				if(isBandeira) {
					desativarBandeira();
				}else {
					ativarBandeira();
				}
			}
			
			for(BotaoCelula[] linhaCelulas: celulas) {
				for(BotaoCelula celula: linhaCelulas) {
					if(celula.over()) {
						celula.click(this.isBandeira);
						if(this.isBandeira) desativarBandeira();
						if(jogo.getPerdeu()) telaMestre.playEffect("data/explosion3.mp3");
					}
				}
			}
		}
		
	}
	
	public void ativarBandeira() {
		this.isBandeira = true;
		app.cursor(this.bandeiraImg);
	}
	
	public void desativarBandeira() {
		this.isBandeira = false;
		app.cursor(app.CROSS);
	}
}
