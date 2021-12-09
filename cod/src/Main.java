import InterfaceGrafica.TelaDificuldade;
import jogo.Jogo;
import InterfaceGrafica.*;
import processing.core.*;
//import processing.sound.*;

public class Main extends PApplet {

	private String estado;
	private TelaInicial telaInicial;
	private TelaDificuldade telaDificuldade;
	private TelaJogo telaJogo;
	private Jogo jogo;
	
    public static void main(String[] args) {
    	PApplet.main(new String[] { "--present", Main.class.getName() });
    }

    public void settings(){
    	size(1000, 600);
    }

    public void setup(){
    	PFont blackOps = createFont("Black Ops.ttf", 32);
    	PImage bg = loadImage("cod.jpg");
    	background(bg);
    	
    	rectMode(CENTER);
    	textAlign(CENTER, CENTER);
    	textFont(blackOps);
    	
    	estado = "Inicial";
    	telaInicial = new TelaInicial(this);
    	telaDificuldade = new TelaDificuldade(this);
    	//telaJogo = new TelaJogo(this, this.telaDificuldade);
    }
    
    public void resetJogo() {
    	jogo = new Jogo(telaDificuldade.getDificuldade(), telaDificuldade.getDistorcao());
    }
    
    void loadBackground(){
    	  PImage bg = loadImage("cod.jpg");
    	  background(bg);
    }
    	  
    public void draw(){
    	stroke(0);
    	 switch(estado){
    	    case "Inicial":
    	        telaInicial.draw();
    	        break;
    	    case "Dificuldade":
    	        telaDificuldade.draw();
    	        resetJogo();
    	        telaJogo = new TelaJogo(this, jogo);
    	        break;
    	    case "Sair":
    	    	exit();
    	    	break;
    	    case "Jogo":
    	    	telaJogo.draw();
    	    	break;
    	 }
    }

    public void mouseClicked(){
    	 switch(estado){
    	   case "Inicial":
    	     estado = telaInicial.mouse();
    	     break;
    	   case "Dificuldade":
    	     estado = telaDificuldade.mouse();
    	     break;
    	   case "Jogo":
    		 estado = telaJogo.mouse();
    		 break;
    	 }
    	 loadBackground();
    }
}
