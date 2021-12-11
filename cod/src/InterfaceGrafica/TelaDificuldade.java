package InterfaceGrafica;
import processing.core.*;


public class TelaDificuldade{
  private int dificuldade;
  private int distorcao;
  private Botao voltar;
  private Botao iniciar;
  private PApplet app;
  private TelaMestre telaMestre;
 
  private BotaoPressionavel dificuldades[];
  private BotaoPressionavel distorcoes[];

  public TelaDificuldade(PApplet app, TelaMestre telaMestre){
	this.app = app;
	this.telaMestre = telaMestre;
    int largura = 200, altura = 50, pos_x = app.width/2, pos_y = app.height/3;
    
    dificuldades = new BotaoPressionavel[3];
    for(int i = 0; i < dificuldades.length; i++) {
    	String label = i == 0? "Fácil": i == 1? "Médio": "Difícil";
        dificuldades[i] = new BotaoPressionavel(app, pos_x - largura- 10 + i*(largura+10), pos_y, largura, altura, label);
    }
    
    distorcoes = new BotaoPressionavel[4];
    for(int i = 0; i < distorcoes.length; i++) {
    	String label = i == 0? "Ausente": i == 1? "Leve": i == 2? "Alta": "Muito Alta";
    	distorcoes[i] = new BotaoPressionavel(app, pos_x - 3*largura/2 -10 + i*(largura+10), pos_y + 200, largura, altura, label);
    }
    
    iniciar = new Botao(app, app.width/2-largura/2-5, app.height-altura, 200, 50, "Iniciar");
    voltar = new Botao(app, app.width/2+largura/2+5, app.height-altura, 200, 50, "Voltar");
    
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
	telaMestre.drawCorDeFundo();
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
  
  public void mouse(){
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
    	telaMestre.changeEstado("Inicial");
    }else if(iniciar.over()) {
    	telaMestre.setJogo(dificuldade, distorcao);
    	telaMestre.changeEstado("Jogo");
    }
  }
  
  private void ativarEscolhidoDesativarOutros(BotaoPressionavel botoes[], int index){
    int i = 0;
    for(BotaoPressionavel botao: botoes){
      botao.setPressionado(index == i? true: false);
      i++;
    }
  }
  
}