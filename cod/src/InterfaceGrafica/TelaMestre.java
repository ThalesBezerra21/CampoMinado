package InterfaceGrafica;
import jogo.Jogo;
import processing.core.*;
import salvar.SaveGame;
//import processing.sound.*;

public class TelaMestre {

	private PApplet app;
	private TelaInicial telaInicial;
	private TelaDificuldade telaDificuldade;
	private TelaJogo telaJogo;
	private Jogo jogo;
	private String estado; //Determina qual tela deve ser desenhada
	
    public TelaMestre(PApplet app) {
    	this.app = app;
    	this.telaInicial = new TelaInicial(app, this);
    	this.telaDificuldade = new TelaDificuldade(app, this);
    	//this.telaJogo = telaJogo;
    	this.estado = "Inicial";
    	loadAlignement();
    	loadBackground();
    	loadFont();
    }

    private void loadAlignement() {
    	app.rectMode(app.CENTER);
    	app.textAlign(app.CENTER, app.CENTER);
    	//app.cursor(app.loadImage("cute_shovel.png"));
    }
    
    private void loadBackground(){
    	  PImage bg = app.loadImage("codgod.jpg");
    	  app.image(bg, 0, 0, app.width, app.height);
    	  //app.background(bg);
    }
    
    private void loadFont() {
    	PFont blackOps = app.createFont("Black Ops.ttf", 32);
    	app.textFont(blackOps);
    }
    	 
    public void resetJogo() {
    	jogo = new Jogo(telaDificuldade.getDificuldade(), telaDificuldade.getDistorcao());
    }
    
    public void loadJogo() {
    	jogo = new SaveGame(jogo).LoadGame();
    	telaJogo = new TelaJogo(app, this, jogo);
    	estado = "Jogo";
    }
    
    public void changeEstado(String estado) {
    	this.estado = estado;
    }
    
    public void draw(){
    	//app.stroke(0);
    	 switch(this.estado){
    	    case "Inicial":
    	        telaInicial.draw();
    	        break;
    	    case "Dificuldade":
    	        telaDificuldade.draw();
    	        resetJogo();
    	        telaJogo = new TelaJogo(app, this, jogo);
    	        break;
    	    case "Sair":
    	    	app.exit();
    	    	break;
    	    case "Jogo":
    	    	telaJogo.draw();
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
    	 }
    	 loadBackground();
    }
}
