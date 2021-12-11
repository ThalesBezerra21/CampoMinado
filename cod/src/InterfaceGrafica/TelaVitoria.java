package InterfaceGrafica;
import processing.core.PApplet;
import processing.core.PImage;

public class TelaVitoria {
	private PApplet app;
	private TelaMestre telaMestre;
	private Botao voltar;
	
	public TelaVitoria(PApplet app, TelaMestre telaMestre) {
		this.app = app;
		this.telaMestre = telaMestre;
		this.voltar = new Botao(app, app.width/2, app.height-70, 200, 50, "Voltar");
	}
	
	public void draw() {
		//telaMestre.loadBackground();
		telaMestre.drawCorDeFundo();
		app.textSize(100);
		app.fill(app.color(255,255,255));
		app.text("Mission completed", app.width/2, app.height/3);
		app.textSize(50);
		app.text("Você venceu", app.width/2, app.height/3 + 100);
		
		voltar.draw();
	}
	
	public void mouse() {
		if(voltar.over()) {
			telaMestre.changeEstado("Inicial");
		}
	}
}
