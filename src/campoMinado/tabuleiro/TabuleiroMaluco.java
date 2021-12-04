package tabuleiro;

import celulas.*;
import exeption.InputInvalidaExeption;

import java.util.*;

public class TabuleiroMaluco extends Tabuleiro {
    
    private int maluquice;

    public TabuleiroMaluco(int lines, int columns, int nivelMaluquice) throws InputInvalidaExeption{
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
            throw new InputInvalidaExeption("Esse nivel de maluquice não existe.");
        }
    }

    public void setFlag(int coordX, int coordY){
        Random rand = new Random();
        int bombX, bombY;
        Cell cell;
        try{
          cell = this.getCell(coordX, coordY);
        }catch(InputInvalidaExeption e){
          throw e;
        }
        if(cell.getFlag()){
          cell.setFlag(false);
        }else{
          if(cell.getBomb() && rand.nextInt(100) < this.maluquice){
              this.setCell(coordX, coordY, new CellSafe(coordX, coordY));
              do{
                bombX = rand.nextInt(this.getColumns());
                bombY = rand.nextInt(this.getLines());
              }while((this.getCell(bombX, bombY).getBomb()) || (this.getCell(bombX, bombY).getOpen()));
                Bomb bomb = new Bomb(bombX, bombY);
                bomb.setFlag(this.getCell(bombX, bombY).getFlag());
                this.setCell(bombX, bombY, bomb);
              }
            this.getCell(coordX, coordY).setFlag(true);
          }
        }   
}