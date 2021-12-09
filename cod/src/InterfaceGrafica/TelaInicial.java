package InterfaceGrafica;
import processing.core.*;

public class TelaInicial{
	
  private PApplet app;
  private TelaMestre telaMestre;
  private Botao botoes[] = new Botao[4];
  
  public TelaInicial(PApplet app, TelaMestre telaMestre){
	  this.app = app;
	  this.telaMestre = telaMestre;
	  carregarBotoes();
  }
  
  private void carregarBotoes(){
    int coordX, coordY;
    int largura = 300, altura = 70;
    String textoBotao;
  
    for(int i = 0; i < 4; i++){
      coordX = app.width/2+10;
      coordY = app.height/2 + (altura+20)*i;
      textoBotao = i == 0? "Iniciar": i == 1? "Continuar": i == 2? "Ranking": "Sair";
      botoes[i] = new Botao(app, coordX, coordY, largura, altura, textoBotao);
      //if(botoes[i].getNome().equals("Continuar")){
        //botoes[i].setAtivado(false);
      //}
    }
  }
  
  public void draw(){
	app.noStroke();
	app.fill(app.color(107,112,92), 25);
    app.rect(app.width/2, (float) (app.height/3.5+10), app.width, app.height/5);
    app.fill(app.color(255,255,255));
    app.textSize(35);
    app.text("Campo Minado", app.width/2+10, app.height/4); 
    app.textSize(55);
    app.text("World Warfare", app.width/2+10, app.height/3); 
  
    for(Botao botao: botoes){
       botao.draw();
    }
  }

  public void mouse(){
      for(Botao botao: botoes){
          if(botao.over() && botao.getAtivado()){
            if(botao.getNome().equals("Iniciar")){
              telaMestre.changeEstado("Dificuldade");
            }else if(botao.getNome().equals("Sair")) {
              telaMestre.changeEstado("Sair");
            }else if(botao.getNome().equals("Continuar")) {
              telaMestre.loadJogo();
            }
          }
      }
   }
}