import java.util.*;

public class Tabuleiro {

	private int lines;
	private int columns;
	private Cell[][] campoMinado;

	public Tabuleiro(int lines, int columns) {
	  this.lines = lines;
	  this.columns = columns;
	  campoMinado = new Cell[this.lines][this.columns];
    fillTabuleiro();
  }

  public void fillTabuleiro(){

    //Put bombs
    for(int k = 0; k < 10; k++){
      Random rand = new Random();
      int bombX = rand.nextInt(this.lines);
      int bombY = rand.nextInt(this.columns);
      campoMinado[bombX][bombY] = new Bomb(); 
    }

    //Put no bombs
	  for(int i = 0; i < this.lines; i++){
		  for(int j = 0; j < this.columns; j++)
		    { 
          if(campoMinado[i][j] == null){
            campoMinado[i][j] = new CellSafe(); 
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
  /**
  // Mudar para uma classe jogo
	public void choseDificult(int dificult) {
		switch (dificult) {
		case 1:
			System.out.println("Game mode set easy!");
			criateCampoMinado(8, 8);
			break;
		case 2:
			System.out.println("Game mode set medium!");
			criateCampoMinado(16, 16);
			break;
		case 3:
			System.out.println("Game mode set hard!");
			criateCampoMinado(24, 24);
			break;
		case 4:
		default:
		}
	}
  **/

	public void printCampoMinado() {
		for (int i = 0; i < campoMinado.length; i++) {
			for (int j = 0; j < campoMinado[0].length; j++) {
				campoMinado[i][j].printCell();
        System.out.print(" ");
			}
      System.out.println("");
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

  public void setFlag(int lines, int columns, boolean status){
    if(validLocation(lines, columns))
      campoMinado[lines][columns].setFlag(status);
  }

}