package InterfaceGrafica;
import jogo.Jogo;
import processing.core.*;

public class TelaJogo {
	private PApplet app;
	//private TelaDificuldade telaDificuldade; 
	private Jogo jogo;
	private BotaoCelula celulas[][];
	private Botao desistir;
	private int dificuldade;
	private int distorcao;
	
	public TelaJogo(PApplet app, Jogo jogo) {
		this.app = app;
		this.dificuldade = jogo.getDificuldade();
		this.distorcao = jogo.getMaluquice();
		this.celulas = new BotaoCelula[jogo.getLines()][jogo.getColumns()];
		for(int i = 0; i < jogo.getLines(); i++) {
			for(int j = 0; j < jogo.getColumns(); j++) {
				int largura = 30;
				this.celulas[i][j] = new BotaoCelula(app, (app.width/2-largura*jogo.getColumns()/2)+i*(largura+5), (app.height/2-largura*jogo.getColumns()/2)+j*(largura+5)-app.height/12, largura, i, j, jogo);
			}
		}
		desistir = new Botao(app, app.width/2, app.height/3+80*4, 200, 50, "Desistir");
	}
	
	public void draw() {	
		String n_dificuldade = dificuldade == 0? "Fácil": dificuldade == 1? "Médio": "Difícil";
		String n_distorcao = distorcao == 0? "Ausente": distorcao == 1? "Leve": distorcao == 2? "Alto": "Muito Alto";
		
		app.fill(app.color(107,112,92), 25);
		app.rect(app.width/2, app.height/2, app.width, app.height);
		
		app.fill(app.color(255,255,255));
		app.textSize(25);
		//app.text("Dificuldade: " + n_dificuldade, app.width/2, app.height/8);
		//app.text("Distorção Cósmica: " + n_distorcao, app.width/2, app.height/6);
		
		for(BotaoCelula[] linhaCelulas: celulas) {
			for(BotaoCelula celula: linhaCelulas) {
				celula.draw();
			}
		}
		desistir.draw();
	}
	
	public String mouse() {
		if(desistir.over()) {
			return "Inicial";
		}
		for(BotaoCelula[] linhaCelulas: celulas) {
			for(BotaoCelula celula: linhaCelulas) {
				if(celula.over()) {
					celula.click();
				}
			}
		}
		return "Jogo";
	}
}
