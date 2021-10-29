public class Tabuleiro {

	private int line;
	private int colum;
	private Cell[][] campoMinado;

	public Tabuleiro(int lines, int columns) {

	this.line = lines;
	this.colum = columns;
	campoMinado = new Cell[this.line][this.colum];
	
	for(int i = 0; i < lines; i++)	  {
		   for(int j = 0; j < columns; j++)
		   {
         // PARA FAZER
			   campoMinado[i][j] = new Cell(false);
         
		   }	      
    }
  }
  public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColum() {
		return colum;
	}

	public void setColum(int colum) {
		this.colum = colum;
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
		if (line < this.line && line >= 0 && colum < this.colum && colum >= 0) {
			return true;
		}
		return false;
	}

  public void openCell(int line, int column){
    if(validLocation(line, column))
      campoMinado[line][column].openCell();
  }

  public void setFlag(int line, int column, boolean status){
    if(validLocation(line, column))
      campoMinado[line][column].setFlag(status);
  }

}