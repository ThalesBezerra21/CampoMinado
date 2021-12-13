package tabuleiro;

import java.util.*;
import exeption.InputInvalidaExeption;
import celulas.*;
import interfaces.Interface;

public class Tabuleiro implements Interface{

	private int lines;
	private int columns;
	public Cell[][] campoMinado;

	public Tabuleiro(int lines, int columns) {
	  this.lines = lines;
	  this.columns = columns;
	  campoMinado = new Cell[this.lines][this.columns];
      fillTabuleiro();
  }

  private void fillTabuleiro(){
    int bombX = 0, bombY = 0;
    int centroX = this.lines/2, centroY = this.columns/2;

    //Carregar celulas sem bomba
    for(int i = 0; i < this.lines; i++){
		  for(int j = 0; j < this.columns; j++)
		    { 
          campoMinado[i][j] = new CellSafe(i, j); 
		    }	      
    }

    //Carregar bombas
    for(int k = 0; k < (lines*columns)/5; k++){
      do{
        Random rand = new Random();
        bombX = rand.nextInt(this.columns);
        bombY = rand.nextInt(this.lines);
      }while((this.getCell(bombX, bombY).getBomb()) ||
    		  ((bombX >= centroX-1 && bombX <= centroX+1) &&
    		  (bombY >= centroY-1 && bombY <= centroY+1)));
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
        int coordX = cell.getX() + i;
        int coordY = cell.getY() + j;
        if(!(i == 0 && j == 0) && isValidLocation(coordX, coordY)){
          Cell vizinho = this.getCell(coordX, coordY);
          if(vizinho != null){
            cell.addVizinho(vizinho);
          } 
        }
      }
    }
  }

  public Cell getCell(int coordX, int coordY) throws InputInvalidaExeption{
    if(isValidLocation(coordX, coordY)){
      return this.campoMinado[coordX][coordY];
    }else{
      throw new InputInvalidaExeption("As coordenadas são inválidas");
    }
  }

  public void setCell(int coordX, int coordY, Cell cell){
    this.campoMinado[coordX][coordY] = cell;
    addTodosVizinhos();
  }
  
  @Override
  public void openCell(int coordX, int coordY) throws InputInvalidaExeption{
    if(isValidLocation(coordX, coordY) && !getCell(coordX, coordY).getOpen()){
      campoMinado[coordX][coordY].openCell();
    }else{
      throw new InputInvalidaExeption("Esta celula é inválida");
    }
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

  public boolean getFlag(int coordX, int coordY){
    return this.getCell(coordX, coordY).getFlag();
  }

  //Se tiver bandeira, coloca, se não tiver, tira
  @Override
  public void setFlag(int coordX, int coordY) throws InputInvalidaExeption{
    Cell cell;
    try{
      cell = this.getCell(coordX, coordY);
    }catch(InputInvalidaExeption e){
      throw e;
    }
    if(cell.getFlag()){
      cell.setFlag(false);
    }else{
      cell.setFlag(true);
    }
    
  }

  public boolean checkVitoria(){
    for(int i = 0; i < this.lines; i++){
		  for(int j = 0; j < this.columns; j++)
		    { 
          if(!campoMinado[i][j].getOpen() && !campoMinado[i][j].getBomb()){
            return false;
          }
		    }	      
    }
    return true;
  }

  public boolean isValidLocation(int coordX, int coordY) {
		if (coordX < this.lines && coordX >= 0 && coordY < this.columns && coordY >= 0) {
			return true;
		}
		return false;
	}
}