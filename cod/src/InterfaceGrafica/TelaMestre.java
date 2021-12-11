package InterfaceGrafica;
import jogo.Jogo;
import processing.core.*;
import salvar.SaveGame;
//import processing.sound.*;

public class TelaMestre {

	private PApplet app;
	private PImage background;
	private TelaInicial telaInicial;
	private TelaDificuldade telaDificuldade;
	private TelaVitoria telaVitoria;
	private TelaDerrota telaDerrota;
	private TelaJogo telaJogo;
	private Jogo jogo;
	private String estado; //Determina qual tela deve ser desenhada
	
    public TelaMestre(PApplet app) {
    	this.app = app;
    	this.telaInicial = new TelaInicial(app, this);
    	this.telaDificuldade = new TelaDificuldade(app, this);
    	this.telaVitoria = new TelaVitoria(app, this);
    	this.telaDerrota = new TelaDerrota(app, this);
    	this.background = app.loadImage("codgod.jpg");
    	this.estado = "Inicial";
    	loadAlignement();
    	loadBackground();
    	loadFont();
    }

    private void loadAlignement() {
    	app.rectMode(app.CENTER);
    	app.textAlign(app.CENTER, app.CENTER);
    }
    
    public void loadBackground(){
    	  app.imageMode(app.CORNER);
    	  app.image(background, 0, 0, app.width, app.height);
    }
    
    public void drawCorDeFundo() {
    	app.noStroke();
    	app.fill(app.color(107,112,92), 25);
    	app.rect(app.width/2, app.height/2, app.width, app.height);
    }
    
    private void loadFont() {
    	PFont blackOps = app.createFont("Black Ops.ttf", 32);
    	app.textFont(blackOps);
    }
    	 
   // public void resetJogo() {
    	//jogo = new Jogo(telaDificuldade.getDificuldade(), telaDificuldade.getDistorcao());
    //}
    
    public Jogo getJogo() {
    	return this.jogo;
    }
    
    public void setJogo(int dificuldade, int distorcao) {
    	jogo = new Jogo(dificuldade, distorcao);
    	telaJogo = new TelaJogo(app, this);
    }
    
    public void loadJogo() {
    	jogo = new SaveGame(jogo).LoadGame();
    	telaJogo = new TelaJogo(app, this);
    	estado = "Jogo";
    }
    
    public void changeEstado(String estado) {
    	loadBackground();
    	this.estado = estado;
    }
    
    public void draw(){
    	 switch(this.estado){
    	    case "Inicial":
    	        telaInicial.draw();
    	        break;
    	    case "Dificuldade":
    	        telaDificuldade.draw();
    	        break;
    	    case "Sair":
    	    	app.exit();
    	    	break;
    	    case "Jogo":
    	    	telaJogo.draw();
    	    	break;
    	    case "Vitoria":
    	    	telaVitoria.draw();
    	    	break;
    	    case "Derrota":
    	    	telaDerrota.draw();
    	    	break;
    	 }
    }

    public void mouseClicked(){
    	 switch(this.estado){
    	   case "Inicial":
    	     telaInicial.mouse();
    	     break;
    	   case "Dificuldade":
    	     telaDificuldade.mouse();
    	     break;
    	   case "Jogo":
    		 telaJogo.mouse();
    		 break;
    	   case "Vitoria":
    		 telaVitoria.mouse();
    	   case "Derrota":
    		 telaDerrota.mouse();
    	 }
    	 loadBackground();
    }
}
