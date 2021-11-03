class Bomb extends Cell {
  
  public Bomb(int coordX, int coordY) {
    super(coordX, coordY);
  }

  public void openCell(){
    setOpen(true);
    setChar('*');
  }

}