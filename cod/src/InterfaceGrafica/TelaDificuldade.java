package InterfaceGrafica;
import processing.core.*;

public class TelaDificuldade{
  private int dificuldade;
  private int distorcao;
  private Botao voltar;
  private Botao iniciar;
  private PApplet app;
 
  private BotaoPressionavel dificuldades[];
  private BotaoPressionavel distorcoes[];
  
  public TelaDificuldade(PApplet app){
	this.app = app;
    int largura = 200, altura = 50, pos_x = app.width/2, pos_y = app.height/3;
    
    dificuldades = new BotaoPressionavel[3];
    dificuldades[0] = new BotaoPressionavel(app, pos_x - largura- 10, pos_y, largura, altura, "Fácil");
    dificuldades[1] = new BotaoPressionavel(app, pos_x, pos_y, largura, altura, "Médio");
    dificuldades[2] = new BotaoPressionavel(app, pos_x + largura + 10, pos_y, largura, altura, "Difícil");
    
    
    distorcoes = new BotaoPressionavel[4];
    distorcoes[0] = new BotaoPressionavel(app, pos_x - 3*largura/2 -10, pos_y + 170, largura, altura, "Ausente");
    distorcoes[1] = new BotaoPressionavel(app, pos_x - largura/2 - 5, pos_y + 170, largura, altura, "Leve");
    distorcoes[2]  = new BotaoPressionavel(app, pos_x + largura/2 + 5, pos_y + 170, largura, altura, "Alta");
    distorcoes[3] = new BotaoPressionavel(app, pos_x + 3*largura/2 + 10, pos_y + 170, largura, altura, "Muito Alta");
    
    iniciar = new Botao(app, app.width/2-largura/2-5, app.height/3+80*4, 200, 50, "Iniciar");
    voltar = new Botao(app, app.width/2+largura/2+5, app.height/3+80*4, 200, 50, "Voltar");
    
    ativarEscolhidoDesativarOutros(dificuldades, 0);
    ativarEscolhidoDesativarOutros(distorcoes, 0);
    this.dificuldade = 0;
    this.distorcao = 0;
  }
  
  public int getDificuldade() {
	  return this.dificuldade;
  }
  
  public int getDistorcao() {
	  return this.distorcao;
  }
  
   public void draw(){
	app.noStroke();
	app.fill(app.color(107,112,92), 25);
	app.rect(app.width/2, app.height/2, app.width, app.height);
    app.fill(app.color(255,255,255));
    app.textSize(25);
    app.text("Dificuldade", app.width/2+10, app.height/3-60); 
    app.text("Distorção Cósmica", app.width/2+10, app.height/2);
    for(BotaoPressionavel botao: dificuldades){
      botao.draw();
    }
    for(BotaoPressionavel botao: distorcoes){
      botao.draw();
    }
    iniciar.draw();
    voltar.draw();
  }
  
  public String mouse(){
    for(int i = 0; i < dificuldades.length; i++){
      if(dificuldades[i].over()){
    	this.dificuldade = i;
        ativarEscolhidoDesativarOutros(dificuldades, i);
      }
    }
    for(int i = 0; i < distorcoes.length; i++){
      if(distorcoes[i].over()){
    	this.distorcao = i;
        ativarEscolhidoDesativarOutros(distorcoes, i);
      }
    }
    if(voltar.over()){
    	return "Inicial";
    }else if(iniciar.over()) {
    	return "Jogo";
    }
    return "Dificuldade";
  }
  
  private void ativarEscolhidoDesativarOutros(BotaoPressionavel botoes[], int index){
    int i = 0;
    for(BotaoPressionavel botao: botoes){
      botao.setPressionado(index == i? true: false);
      i++;
    }
  }
  
}