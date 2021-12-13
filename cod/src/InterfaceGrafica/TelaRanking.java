package InterfaceGrafica;

import processing.core.PApplet;

public class TelaRanking {
	private PApplet app;
	private TelaMestre telaMestre;
	private Botao voltar;
	
	public TelaRanking(PApplet app, TelaMestre telaMestre) {
		this.app = app;
		this.telaMestre = telaMestre;
		this.voltar = new Botao(app, app.width/2, app.height-70, 200, 50, "Voltar");
	}
	
	public void draw() {
		telaMestre.drawCorDeFundo();
		app.fill(app.color(255, 255, 255));
		app.textSize(40);
		app.text("Ranking", app.width/2, app.height/8);
		voltar.draw();
	}
	
	public void mouse() {
		if(voltar.over()) {
			telaMestre.changeEstado("Inicial");
		}
	}
}
