package InterfaceGrafica;
import processing.core.PApplet;
import processing.core.PImage;

public class TelaVitoria {
	private PApplet app;
	private TelaMestre telaMestre;
	private TextBox textBox;
	private Botao continuar;
	private int pontuacao;
	
	public TelaVitoria(PApplet app, TelaMestre telaMestre, int pontuacao) {
		this.app = app;
		this.telaMestre = telaMestre;
		this.textBox = new TextBox(app);
		this.continuar = new Botao(app, app.width/2, app.height-70, 200, 50, "Continuar");
		this.pontuacao = pontuacao;
	}
	
	public void draw() {
		telaMestre.drawCorDeFundo();
		app.textSize(100);
		app.fill(app.color(255,255,255));
		app.text("Mission completed", app.width/2, app.height/3);
		app.textSize(50);
		app.text("Digite seu nome:", app.width/2, app.height/2 + app.height/10);
		textBox.draw();
		continuar.draw();
	}
	
	public void mouse() {
		if(continuar.over() && !textBox.isEmpty()) {
			prosseguir();
		}
	}
	
	public void keyPressed(){
		if(textBox.keyPressed(app.key, app.keyCode) && !textBox.isEmpty()) {
			prosseguir();
		}
	}
	
	public void prosseguir() {
		if(!textBox.isEmpty()) {
			telaMestre.changeEstado("Inicial");
			telaMestre.salvarPontuacao(textBox.getText(), this.pontuacao);
		}
		
	}
}
