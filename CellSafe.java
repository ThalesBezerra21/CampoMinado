import java.util.*;

class CellSafe extends Cell {

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
          if(cell instanceof CellSafe){
            CellSafe cs = (CellSafe) cell;
            cs.openCell();
         }
        }
      }else{
        setChar(Character.forDigit(bombsNearby, 10));
      }
    }
    
  }
  
  public void addVizinhos(Tabuleiro tab){
    Cell cell;
    for(int i = -1; i < 2; i++){
      for(int j = -1; j < 2; j++){
        if(!(i == 0 && j == 0)){
          cell = tab.getCell(getX() + i, getY() + j);
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