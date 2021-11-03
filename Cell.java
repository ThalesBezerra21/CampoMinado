class Cell{

  private boolean isOpen;
  private boolean hasFlag;
  private char cellChar;
  
  public Cell(){
    this.isOpen = false;
    this.cellChar = '-';
    setFlag(false);
  }

  public void openCell(){}

  public boolean getOpen(){
    return this.isOpen;
  }

  public void setOpen(boolean status){
    this.isOpen = status;
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

}