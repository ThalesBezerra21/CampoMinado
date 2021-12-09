package InterfaceGrafica;
import jogo.Jogo;
import processing.core.*;
import salvar.SaveGame;

public class TelaJogo {
	private PApplet app;
	private TelaMestre telaMestre;
	private Jogo jogo;
	private BotaoCelula celulas[][];
	private Botao salvar;
	private Botao desistir;
	private int dificuldade;
	private int distorcao;
	
	public TelaJogo(PApplet app, TelaMestre telaMestre, Jogo jogo) {
		this.app = app;
		this.telaMestre = telaMestre;
		this.dificuldade = jogo.getDificuldade();
		this.distorcao = jogo.getMaluquice();
		this.celulas = new BotaoCelula[jogo.getLines()][jogo.getColumns()];
		for(int i = 0; i < jogo.getLines(); i++) {
			for(int j = 0; j < jogo.getColumns(); j++) {
				int largura = 40;
				this.celulas[i][j] = new BotaoCelula(app, (app.width/2-largura*jogo.getColumns()/2)+i*(largura+1), (app.height/2-largura*jogo.getColumns()/2)+j*(largura+1)-app.height/12, largura, i, j, jogo);
			}
		}
		desistir = new Botao(app, app.width/2+105, app.height-200, 200, 50, "Desistir");
		salvar = new Botao(app, app.width/2-105, app.height-200, 200, 50, "Salvar e sair");
	}
	
	public void draw() {	
		String n_dificuldade = dificuldade == 0? "Fácil": dificuldade == 1? "Médio": "Difícil";
		String n_distorcao = distorcao == 0? "Ausente": distorcao == 1? "Leve": distorcao == 2? "Alto": "Muito Alto";
		
		app.fill(app.color(107,112,92), 25);
		app.rect(app.width/2, app.height/2, app.width, app.height);
		
		app.fill(app.color(255,255,255));
		app.textSize(25);
		
		for(BotaoCelula[] linhaCelulas: celulas) {
			for(BotaoCelula celula: linhaCelulas) {
				celula.draw();
			}
		}
		salvar.draw();
		desistir.draw();
	}
	
	public void mouse() {
		if(desistir.over()) {
			telaMestre.changeEstado("Inicial");
		}else if(salvar.over()) {
			SaveGame game = new SaveGame(jogo);
			telaMestre.changeEstado("Inicial");
		}
		for(BotaoCelula[] linhaCelulas: celulas) {
			for(BotaoCelula celula: linhaCelulas) {
				if(celula.over()) {
					celula.click();
				}
			}
		}
	}
}
