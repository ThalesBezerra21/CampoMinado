import java.util.*;

class Cell{

  private boolean isBomb;
  private boolean isOpen;
  private boolean hasFlag;
  private char cellChar;
  private Set<Cell> vizinhos;

  public Cell(boolean isBomb){
    this.isBomb = isBomb;
    this.isOpen = false;
    setFlag(false);
    vizinhos = new HashSet<>();
  }

  public void openCell(){
    this.isOpen = true;
    if(getBomb()){
      setChar('*');
    }else{
      setChar(Character.forDigit(countBombsNearby(), 10));
    }
  }

  public boolean getOpen(){
    return this.isOpen;
  }

  public boolean getBomb(){
    return this.isBomb;
  }

  public void setFlag(boolean status){
    this.hasFlag = status;
    if(status){
      if(!getOpen()){
        setChar('P');
      }
    }else{
      if(!getOpen()){
        setChar('-');
      }
    }
  }

  public boolean getFlag(){
    return this.hasFlag;
  }

  public void setChar(char chr){
    this.cellChar = chr;
  }

  public char getChar(){
    return this.cellChar;
  }

  public void printCell(){
    System.out.print(getChar());
  }

  public void addVizinho(Cell cell){
    if(vizinhos.size() < 9)
      vizinhos.add(cell);
  }

  public int countBombsNearby(){
    int count = 0;
    for(Cell cell: vizinhos){
      if(cell.getBomb()) count ++;
    }
    return count;
  }


}