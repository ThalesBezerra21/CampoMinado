import java.util.*;

public class Tabuleiro {

	private int lines;
	private int columns;
	public Cell[][] campoMinado;

	public Tabuleiro(int lines, int columns) {
	  this.lines = lines;
	  this.columns = columns;
	  campoMinado = new Cell[this.lines][this.columns];
  }

  public void fillTabuleiro(){
    int bombX = 0, bombY = 0;

    //Put safe cells
    for(int i = 0; i < this.lines; i++){
		  for(int j = 0; j < this.columns; j++)
		    { 
          campoMinado[i][j] = new CellSafe(i, j); 
		    }	      
    }

    //Put bombs
    for(int k = 0; k < (lines*columns)/4; k++){
      do{
        Random rand = new Random();
        bombX = rand.nextInt(this.columns);
        bombY = rand.nextInt(this.lines);
      }while((campoMinado[bombX][bombY] instanceof Bomb));
      campoMinado[bombX][bombY] = new Bomb(bombX, bombY);
    }

    //Add neighbors
    for(int i = 0; i < this.lines; i++){
		  for(int j = 0; j < this.columns; j++)
		    { 
          if(!(campoMinado[i][j] instanceof Bomb)){
            ((CellSafe) campoMinado[i][j]).addVizinhos(this);
          }
		    }	      
    }
	  
  }

  public int getLine() {
		return lines;
	}

	public void setLine(int lines) {
		this.lines = lines;
	}

	public int getColum() {
		return columns;
	}

	public void setColum(int columns) {
		this.columns = columns;
	}

  public Cell getCell(int coordX, int coordY){
    if(validLocation(coordX, coordY)){
      return this.campoMinado[coordX][coordY];
    }else{
      return null;
    }
  }
  
	public void printCampoMinado() {
    System.out.print("    ");
    for(int i = 0; i < campoMinado.length; i++){
      System.out.print(i+1);
      System.out.print("  ");
    }
    System.out.println();
    System.out.println();

		for (int i = 0; i < campoMinado.length; i++) {
			System.out.print(i+1);
      System.out.print("   ");
      for (int j = 0; j < campoMinado[0].length; j++) {
				campoMinado[i][j].printCell();
        System.out.print("  ");
			}
      System.out.println();
		}
	}

	public boolean validLocation(int line, int colum) {
		if (line < this.lines && line >= 0 && colum < this.columns && colum >= 0) {
			return true;
		}
		return false;
	}

  public void openCell(int lines, int columns){
    if(validLocation(lines, columns))
      campoMinado[lines][columns].openCell();
  }

  public void setFlag(int lines, int columns){
    if(validLocation(lines, columns)){
      Cell cell = campoMinado[lines][columns];
      if(cell.getFlag()){
        cell.setFlag(false);
      }else{
        cell.setFlag(true);
      }
    }
  }

}