package InterfaceGrafica;
import jogo.Jogo;
import processing.core.*;
import salvar.SaveGame;
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
	private int gameOver = 0;
	
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
				this.celulas[i][j] = new BotaoCelula(app, (app.width/2-largura*jogo.getColumns()/2)+i*(largura+1), (app.height/2-largura*jogo.getColumns()/2)+j*(largura+1)-app.height/12, largura, i, j, jogo, bombaImg, bandeiraImg);
			}
		}
		desistir = new Botao(app, app.width/2+105, app.height-70, 200, 50, "Desistir");
		salvar = new Botao(app, app.width/2-105, app.height-70, 200, 50, "Salvar e sair");
		colocarBandeira = new Botao(app, app.width/2, app.height-130, 410, 50, "Bandeira");
		
		bandeiraImg = app.loadImage("flag.png");
		bandeiraImg.resize(40, 40);
	}
	
	public void draw() {	
		this.jogo = telaMestre.getJogo();
		
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
		
		if(jogo.getPerdeu() || jogo.getVitoria()) {
			if(gameOver == 1) {
				app.delay(2000);
				telaMestre.changeEstado(jogo.getPerdeu()? "Derrota": "Vitoria");
				gameOver = 2;
			}else if (gameOver == 0){
				gameOver = 1;
			}
		}
	}
	
	public void mouse() {
		if(desistir.over()) {
			telaMestre.changeEstado("Inicial");
			desativarBandeira();
		
		}else if(salvar.over()) {
			SaveGame game = new SaveGame(jogo);
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
