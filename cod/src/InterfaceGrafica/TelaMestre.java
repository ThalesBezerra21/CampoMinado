package InterfaceGrafica;
import jogo.Jogo;
import processing.core.*;
import salvar.LoadJogo;
import salvar.SaveGame;
import ddf.minim.*;

public class TelaMestre {

	private PApplet app;
	private PImage background;
	private TelaInicial telaInicial;
	private TelaDificuldade telaDificuldade;
	private TelaVitoria telaVitoria;
	private TelaDerrota telaDerrota;
	private TelaRanking telaRanking;
	private TelaJogo telaJogo;
	private Jogo jogo;
	private String estado; //Determina qual tela deve ser desenhada
	private Minim minim;
	private AudioPlayer player;
	
    public TelaMestre(PApplet app) {
    	this.app = app;
    	this.telaInicial = new TelaInicial(app, this);
    	this.telaDificuldade = new TelaDificuldade(app, this);
    	this.telaVitoria = new TelaVitoria(app, this);
    	this.telaDerrota = new TelaDerrota(app, this);
    	this.telaRanking = new TelaRanking(app, this);
    	this.background = app.loadImage("codgod.jpg");
    	this.estado = "Inicial";
    	minim = new Minim(app);
    	playMusic("data/playing.mp3");
    	//playMusic("data/mobile.mp3");
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
    	LoadJogo.LoadJogo();
    	telaJogo = new TelaJogo(app, this);
    	estado = "Jogo";
    }
    
    public void changeEstado(String estado) {
    	loadBackground();
    	this.estado = estado;
    }
    
    public String getEstado() {
    	return this.estado;
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
    	    case "Ranking":
    	    	telaRanking.draw();
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
    		 break;
    	   case "Derrota":
    		 telaDerrota.mouse();
    		 break;
    	   case "Ranking":
    		 telaRanking.mouse();
    		 break;
    	 }
    	 loadBackground();
    }
    
    public void playMusic(String path) {
    	player = minim.loadFile(path);
    	player.loop(); 
    }
    
    public void playEffect(String path) {
    	player = minim.loadFile(path);
    	player.play();
    }
}
