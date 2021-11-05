class Cell{

  private int coordX;
  private int coordY;
  private boolean isOpen;
  private boolean hasFlag;
  private char cellChar;
  
  public Cell(int coordX, int coordY){
    this.coordX = coordX;
    this.coordY = coordY;
    this.isOpen = false;
    this.cellChar = '-';
    setFlag(false);
  }

  public int getX(){
    return this.coordX;
  }

  public int getY(){
    return this.coordY;
  }

  public void openCell(){}

  public boolean getOpen(){
    return this.isOpen;
  }

  public void setOpen(boolean status){
    this.isOpen = status;
  }

  public void setFlag(boolean status){
    hasFlag = status;
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
    return hasFlag;
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

}