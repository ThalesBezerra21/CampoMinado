package campoMinado.tabuleiro;

import java.util.*;

import campoMinado.celulas.*;

public class Tabuleiro implements campoMinado.Interface{

	private int lines;
	private int columns;
	public Cell[][] campoMinado;
  public boolean vitoria;
  public boolean perdeu;

	public Tabuleiro(int lines, int columns) {
	  this.lines = lines;
	  this.columns = columns;
    this.vitoria = false;
    this.perdeu = false;
	  campoMinado = new Cell[this.lines][this.columns];
    fillTabuleiro();
  }

  private void fillTabuleiro(){
    int bombX = 0, bombY = 0;

    //Carregar celulas sem bomba
    for(int i = 0; i < this.lines; i++){
		  for(int j = 0; j < this.columns; j++)
		    { 
          campoMinado[i][j] = new CellSafe(i, j); 
		    }	      
    }

    //Carregar bombas
    for(int k = 0; k < (lines*columns)/4; k++){
      do{
        Random rand = new Random();
        bombX = rand.nextInt(this.columns);
        bombY = rand.nextInt(this.lines);
      }while((this.getCell(bombX, bombY).getBomb()));
      campoMinado[bombX][bombY] = new Bomb(bombX, bombY);
    }

    addTodosVizinhos();
	  
  }

  private void addTodosVizinhos(){
    //Adicionar vizinhos
    for(int i = 0; i < this.lines; i++){
		  for(int j = 0; j < this.columns; j++)
		    { 
          Cell cell = campoMinado[i][j];
          cell.resetVizinhos();
          this.addVizinhosCelula(cell);
          if(cell.getOpen()) ((CellSafe)cell).atualizarNumero();
		    }	      
    }
  }

  //Adiciona os vizinhos da celula input. 
  //Privado pois se deve usar apenas em fillTabuleiro
  private void addVizinhosCelula(Cell cell){
    for(int i = -1; i < 2; i++){
      for(int j = -1; j < 2; j++){
        if(!(i == 0 && j == 0)){
          Cell vizinho = this.getCell(cell.getX() + i, cell.getY() + j);
          if(vizinho != null){
            cell.addVizinho(vizinho);
          } 
        }
      }
    }
  }

  public Cell getCell(int coordX, int coordY){
    if(isValidLocation(coordX, coordY) && !this.vitoria){
      return this.campoMinado[coordX][coordY];
    }else{
      return null;
    }
  }

  public void setCell(int coordX, int coordY, Cell cell){
    this.campoMinado[coordX][coordY] = cell;
    addTodosVizinhos();
  }
  
  @Override
  public void openCell(int coordX, int coordY){
    if(isValidLocation(coordX, coordY) && !this.vitoria){
      campoMinado[coordX][coordY].openCell();
      if(campoMinado[coordX][coordY].getBomb()) this.perdeu = true;
    }
    checkVitoria();
  }

  public Cell[][] getTabuleiro(){
    return this.campoMinado;
  }

  public int getLines() {
		return lines;
	}

	public int getColumns() {
		return columns;
	}

  public boolean getVitoria(){
    return this.vitoria;
  }

  public boolean getPerdeu(){
    return this.perdeu;
  }

	public boolean isValidLocation(int coordX, int coordY) {
		if (coordX < this.lines && coordX >= 0 && coordY < this.columns && coordY >= 0) {
			return true;
		}
		return false;
	}

  public boolean getFlag(int coordX, int coordY){
    return this.getCell(coordX, coordY).getFlag();
  }

  //Se tiver bandeira, coloca, se não tiver, tira
  @Override
  public void setFlag(int coordX, int coordY){
    if(isValidLocation(coordX, coordY) && !this.vitoria){
      Cell cell = this.getCell(coordX, coordY);
      if(cell.getFlag()){
        cell.setFlag(false);
      }else{
        cell.setFlag(true);
      }
    }
  }

  public void checkVitoria(){
    for(int i = 0; i < this.lines; i++){
		  for(int j = 0; j < this.columns; j++)
		    { 
          if(!campoMinado[i][j].getOpen() && !campoMinado[i][j].getBomb()){
            return;
          }
		    }	      
    }
    this.vitoria = true;
  }
}