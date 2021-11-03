import java.util.*;

class CellSafe extends Cell {

  private Set<Cell> vizinhos;

  public CellSafe(int coordX, int coordY){
    super(coordX, coordY);
    vizinhos = new HashSet<>();
  }

  public void openCell(){
    int bombsNearby = countBombsNearby();
    setOpen(true);
    if(bombsNearby == 0){
      setChar(' ');
      for(Cell cell: vizinhos){
        cell.openCell();
      }
    }else{
      setChar(Character.forDigit(bombsNearby, 10));
    }
  }
  
  public void addVizinhos(Tabuleiro tab){
    Cell cell;
    for(int i = -1; i < 2; i++){
      for(int j = -1; j < 2; j++){
        if(!(i == 0 && j == 0)){
          cell = tab.getCell(getX(), getY());
          if(cell != null){
            this.vizinhos.add(cell);
            
          } 
        }
      }
    }
  }

  public int countBombsNearby(){
    int count = 0;
    for(Cell cell: vizinhos){
      if(cell instanceof Bomb) count ++;
    }
    return count;
  }

}