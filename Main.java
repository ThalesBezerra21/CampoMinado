import java.util.*;

class Main {
  public static void main(String[] args) {
    /*
    Cell cell = new Cell(true);
    
    cell.printCell();
    System.out.println();

    cell.setFlag(true);
    cell.printCell();
    System.out.println();

    cell.setFlag(false);
    cell.printCell();
    System.out.println();
    
    cell.openCell();
    cell.printCell();
    **/

     /*
    Cell cell1 = new Cell(false);
    Cell cell2 = new Cell(true);
    Cell cell3 = new Cell(true);

    cell1.addVizinho(cell2);
    cell1.addVizinho(cell3);

    cell1.openCell();
    cell1.printCell();
    **/

  /**
    Tabuleiro tab = new Tabuleiro(8, 8);
    tab.printCampoMinado();

    System.out.println();

    tab.setFlag(5, 5, true);
    tab.printCampoMinado();

    System.out.println();

    tab.openCell(4, 3);
    tab.printCampoMinado();
    **/

    Jogo jogo = new Jogo();

    /** 
    System.out.println("rodando...");
    Tabuleiro tab = new Tabuleiro(8,8);
    tab.fillTabuleiro();
    tab.printCampoMinado();

    for(Cell[] line: tab.campoMinado){
      for(Cell cell: line){
        if(cell instanceof CellSafe){
          CellSafe cellSafe = (CellSafe) cell;
          System.out.println("vizinhos: ");
          Set<Cell> vizinhos = cellSafe.getVizinhos();
          for(Cell vizinho: vizinhos){
            System.out.println("  ");
            vizinho.printCell();
            System.out.println("");
          }
        }
      }
    }
    **/

  }
}