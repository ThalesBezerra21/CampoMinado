package InterfaceGrafica;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import ranking.Ranking;

public class TelaRanking {
	private PApplet app;
	private TelaMestre telaMestre;
	private Botao voltar;
	private Ranking ranking;
	private Table table;
	
	public TelaRanking(PApplet app, TelaMestre telaMestre) {
		this.app = app;
		this.telaMestre = telaMestre;
		this.voltar = new Botao(app, app.width/2, app.height-70, 200, 50, "Voltar");
	}
	
	public void draw() {
		loadRanking();
		
		telaMestre.drawCorDeFundo();
		app.fill(app.color(255, 255, 255));
		app.textSize(40);
		app.text("Ranking", app.width/2, app.height/8);
		voltar.draw();
		
		drawRanking();
	}
	
	public void mouse() {
		if(voltar.over()) {
			telaMestre.changeEstado("Inicial");
		}
	}
	
	public void drawRanking() {
		loadRanking();
		
		int numEntradas = 10;
		int altura = 40; 
	    int indentacaoX = app.width/3;
	    int indentacaoY = app.height/5;
		int larguraNome = 400;
		int larguraPont = 200;
		int numRows = table.getRowCount();
		
		
		app.rectMode(app.CORNER);
		//app.stroke(app.color(0,0,0));
		app.textSize(20);
		
		for(int i = 0; i < numEntradas; i++) {
			
			int coordXNome = indentacaoX;
			int coordYNome = indentacaoY+i*(altura+10);
			int coordXPont = indentacaoX+larguraNome+10;
			int coordYPont = indentacaoY+i*(altura+10);
			
			app.fill(app.color(165,165,141));
			app.rect(coordXNome, coordYNome, larguraNome, altura);
			app.rect(coordXPont, coordYPont, larguraPont, altura);
			
			app.fill(app.color(255,255,255));
			app.textAlign(app.CORNER, app.CENTER);
			app.text((i+1)+".",coordXNome+10, coordYNome+10);
			app.textAlign(app.CENTER, app.CENTER);
			
			if(i < numRows) {
				TableRow row = table.getRow(i);
				app.text(row.getString("nome").toUpperCase(), coordXNome+larguraNome/2, coordYNome+altura/2);
				app.text(row.getInt("pontuacao"), coordXPont+larguraPont/2, coordYPont+altura/2);
			}
		}
		
		app.noStroke();
		app.rectMode(app.CENTER);
	}
	
	public void loadRanking() {
		this.ranking = new Ranking(app);
		this.table = this.ranking.getTable();
	}
}
