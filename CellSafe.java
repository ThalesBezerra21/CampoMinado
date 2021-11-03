import java.util.*;

class CellSafe extends Cell {

  private Set<Cell> vizinhos;

  public CellSafe(){
    super();
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
  
  public void addVizinho(Cell cell){
    if(vizinhos.size() < 9)
      vizinhos.add(cell);
  }

  public int countBombsNearby(){
    int count = 0;
    for(Cell cell: vizinhos){
      if(cell instanceof Bomb) count ++;
    }
    return count;
  }

}