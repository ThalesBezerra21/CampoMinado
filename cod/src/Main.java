import InterfaceGrafica.TelaMestre;
import processing.core.*;
//import processing.sound.*;

public class Main extends PApplet {

	private TelaMestre telaMestre;
	
    public static void main(String[] args) {
    	PApplet.main(new String[] { "--present", Main.class.getName() });   
    }

    public void settings(){
    	fullScreen();
    }

    public void setup(){
    	this.telaMestre = new TelaMestre(this);
    	cursor(CROSS);
    }
    	  
    public void draw(){
    	telaMestre.draw(); 
    }

    public void mouseClicked(){
    	telaMestre.mouseClicked();
    }
    
    public void keyPressed() {
    	telaMestre.keyPressed();
    }
}
