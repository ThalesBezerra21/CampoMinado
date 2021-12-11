package InterfaceGrafica;
import processing.core.*;

public class Botao{  
  private int coordX, coordY, largura, altura;
  private String nome;
  private boolean ativado;
  private PApplet app;
  
  public Botao(PApplet app, int x, int y, int l, int a, String n){
	this.app = app;
    coordX = x;
    coordY = y;
    largura = l;
    altura = a;
    nome = n;
    ativado = true;
  }
  
  public int getCoordX() {
	  return coordX;
  }

  public void setCoordX(int coordX) {
	  this.coordX = coordX;
  }

  public int getCoordY() {
	  return coordY;
  }

  public void setCoordY(int coordY) {
	this.coordY = coordY;
  }


  public int getLargura() {
	  return largura;
  }


  public void setLargura(int largura) {
	  this.largura = largura;
  }


  public int getAltura() {
	  return altura;
  }


  public void setAltura(int altura) {
	  this.altura = altura;
  }


  public PApplet getApp() {
	  return app;
  }

  public void setApp(PApplet app) {
	  this.app = app;
  }
  
  public String getNome(){
    return nome;
  }
  
  public void setNome(String n) {
	 this.nome = n;
  }
  
  public void setNome(char ch) {
	  this.nome = Character.toString(ch);
  }
  
  public boolean getAtivado(){
    return this.ativado;
  }
  
  public void setAtivado(boolean status){
    this.ativado = status;
  }
  
  public void draw(){
    if(over() && ativado){
    	app.fill(app.color(107,112,92));
    	app.textSize(25);
    }else{
    	app.fill(ativado? app.color(165,165,141): app.color(155,155,155));
      app.textSize(20);
    }
    app.rect(coordX, coordY, largura, altura);
    app.fill(app.color(255,255,255));
    app.text(nome, coordX, coordY);
  }
  
  public boolean over(){
    if (app.mouseX >= coordX-largura/2 && app.mouseX <= coordX+largura/2 && 
    		app.mouseY >= coordY-altura/2 && app.mouseY <= coordY+altura/2) {
      return true;
    }else {
      return false;
    }
   }

}