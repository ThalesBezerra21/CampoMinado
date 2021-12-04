package celulas;

public class CellSafe extends Cell {

  public CellSafe(int coordX, int coordY){
    super(coordX, coordY);
  }

  public void openCell(){
    if(!this.getOpen()){
      setOpen(true);
      int bombsNearby = countBombsNearby();
      if(bombsNearby == 0){
        setChar(' ');
        for(Cell cell: this.getVizinhos()){
          cell.openCell();
        }
      }else{
        atualizarNumero();
      }
    }
  }

  public void atualizarNumero(){
    int bombsNearby = countBombsNearby();
    setChar(bombsNearby == 0? ' ': Character.forDigit(bombsNearby, 10));
  }
  
  public int countBombsNearby(){
    int count = 0;
    for(Cell cell: this.getVizinhos()){
      if(cell.getBomb()) count ++;
    }
    return count;
  }

}