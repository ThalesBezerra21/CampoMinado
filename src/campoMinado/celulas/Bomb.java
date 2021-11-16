package campoMinado.celulas;

public class Bomb extends Cell {
  
  public Bomb(int coordX, int coordY) {
    super(coordX, coordY);
    this.setBomb(true);
  }

  public void openCell(){
    setOpen(true);
    setChar('*');
  }

}