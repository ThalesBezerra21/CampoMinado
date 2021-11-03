class Bomb extends Cell {
  
  public Bomb() {
    super();
  }

  public void openCell(){
    setOpen(true);
    setChar('*');
  }

}