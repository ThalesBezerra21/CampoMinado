package campoMinado.celulas;
import java.util.*;

public class CellSafe extends Cell {

  private Set<Cell> vizinhos;

  public CellSafe(int coordX, int coordY){
    super(coordX, coordY);
    vizinhos = new HashSet<>();
  }

  public Set<Cell> getVizinhos(){
    return this.vizinhos;
  }

  public void openCell(){
    if(!getOpen()){
      setOpen(true);
      int bombsNearby = countBombsNearby();
      if(bombsNearby == 0){
        setChar(' ');
        for(Cell cell: vizinhos){
            cell.openCell();
         }
      }else{
        setChar(Character.forDigit(bombsNearby, 10));
      }
    }
    
  }
  
  public void addVizinho(Cell cell){
    this.vizinhos.add(cell);
  }

  public int countBombsNearby(){
    int count = 0;
    for(Cell cell: vizinhos){
      if(cell.getBomb()) count ++;
    }
    return count;
  }

}