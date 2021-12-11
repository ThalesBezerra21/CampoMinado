package InterfaceGrafica;
import processing.core.*;

public class BotaoPressionavel extends Botao{
  private boolean pressionado;
  private PApplet app;
  
  public BotaoPressionavel(PApplet app, int x, int y, int l, int a, String n){
    super(app, x, y, l, a, n);
    this.app = app;
    pressionado = false;
  }
  
  public boolean getPressionado(){
    return pressionado;
  }
  
  public void setPressionado(boolean status){
    this.pressionado = status;
  }
  
  public void draw(){
	app.rectMode(app.CENTER);
	app.textAlign(app.CENTER, app.CENTER);
    if(pressionado){
    	app.fill(app.color(107,112,92));
    	app.textSize(25);
    }else{
    	app.fill(app.color(165,165,141));
    	app.textSize(20);
    }
    app.rect(this.getCoordX(), this.getCoordY(), this.getLargura(), this.getAltura());
    app.fill(app.color(255,255,255));
    app.text(this.getNome(), this.getCoordX(), this.getCoordY());
  }
}