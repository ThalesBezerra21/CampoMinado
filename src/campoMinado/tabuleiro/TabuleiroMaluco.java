package campoMinado.tabuleiro;

import campoMinado.celulas.*;
import java.util.*;

public class TabuleiroMaluco extends Tabuleiro {
    
    private int maluquice;

    public TabuleiroMaluco(int lines, int columns, int nivelMaluquice){
        super(lines, columns);
        switch(nivelMaluquice){
          case 1:
            this.maluquice = 50;
            break;
          case 2: 
            this.maluquice = 70;
            break;
          case 3: 
            this.maluquice = 90;
            break;
          default:
            maluquice = 25;
            break;
        }
    }

    public void setFlag(int coordX, int coordY){
        Random rand = new Random();
        if(isValidLocation(coordX, coordY)){
          Cell cell = this.getCell(coordX, coordY);
          if(cell.getFlag()){
            cell.setFlag(false);
          }else{
            if(cell.getBomb() && rand.nextInt(100) < this.maluquice){
                this.setCell(coordX, coordY, new CellSafe(coordX, coordY));
            }
            this.getCell(coordX, coordY).setFlag(true);
          }
        }
      }
}