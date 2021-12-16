package ranking;

import java.io.File;
import java.io.IOException;

import exeption.InputInvalidaExeption;
import processing.core.*;
import processing.data.Table;
import processing.data.TableRow;

public class Ranking{

    private PApplet app;
    private Table table;
    private File arquivo;
    
    public Ranking(PApplet app) {
    	this.app = app;
    	
    	try {
    		this.arquivo = new File("data/ranking.csv");

			if (!arquivo.exists()) {
				arquivo.createNewFile();
				criarColunas();
			}
			
			this.table = app.loadTable("data/ranking.csv", "header");
		} catch (IOException io) {
			io.printStackTrace();
			throw new InputInvalidaExeption("Esse arquivo não existe");
		}
    }
    
    public void criarColunas() {
    	  table = new Table();
    	  
    	  table.addColumn("id", Table.INT);
    	  table.addColumn("nome");
    	  table.addColumn("pontuacao", Table.INT);
    	  
    	  app.saveTable(table, "data/ranking.csv");
    }
    
    public void adicionarEntrada(Pessoa pessoa) {
    	TableRow newRow = this.table.addRow();
    	newRow.setInt("id", table.getRowCount());
    	newRow.setString("nome", pessoa.getNome());
    	newRow.setInt("pontuacao", pessoa.getPontuacao());
    	
    	table.sortReverse("pontuacao");
    	app.saveTable(table, "data/ranking.csv");
    	this.table = app.loadTable("data/ranking.csv", "header");
    }
   
    public Table getTable() {
    	return this.table;
    }
 }



