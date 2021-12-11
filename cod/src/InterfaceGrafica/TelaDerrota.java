package InterfaceGrafica;


import processing.core.PApplet;

public class TelaDerrota {
	private PApplet app;
	private TelaMestre telaMestre;
	private Botao voltar;
	
	public TelaDerrota(PApplet app, TelaMestre telaMestre) {
		this.app = app;
		this.telaMestre = telaMestre;
		this.voltar = new Botao(app, app.width/2, app.height-70, 200, 50, "Voltar");
	}
	
	public void draw() {
		telaMestre.drawCorDeFundo();
		app.fill(app.color(200, 0, 0), 25);
		app.rect(app.width/2, app.height/2, app.width, app.height);
		app.textSize(100);
		app.fill(app.color(255,255,255));
		app.text("Mission failed", app.width/2, app.height/3);
		app.textSize(50);
		app.text("Você perdeu", app.width/2, app.height/3 + 100);
		
		voltar.draw();
	}
	
	public void mouse() {
		if(voltar.over()) {
			telaMestre.changeEstado("Inicial");
		}
	}
}
