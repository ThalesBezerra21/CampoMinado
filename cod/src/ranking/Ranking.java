package ranking;

import java.io.*;
import java.util.*;

import exeption.InputInvalidaExeption;

public class Ranking{
	 
    private File aqrTXT;
    
    public Ranking(Pessoa p) {
    	try {
			aqrTXT = new File("./Ranking.txt");

			if (!aqrTXT.exists()) {
				aqrTXT.createNewFile();	
				aqrTXT = new File("./Ranking.txt");
			}			
		} catch (IOException io) {
			io.printStackTrace();
			throw new InputInvalidaExeption("Esse arquivo não existe");
		}
    	criarRanking(p);
    	
    	
    }
        
    public void criarRanking(Pessoa p) {

            try {
                
                BufferedWriter fileWriter = new BufferedWriter( new FileWriter(aqrTXT, true));
                PrintWriter pW = new PrintWriter(fileWriter);
                pW.print(p.getNome()+" ("+p.getPontuacao()+") ");
                pW.flush();
                pW.close();
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
        private File lerRanking() {

            try {
            	
                FileReader fileReader = new FileReader(aqrTXT);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
               
                String linha = "";                
                while ( ( linha = bufferedReader.readLine() ) != null) {
                //System.out.println(linha);
            }
                fileReader.close();
                bufferedReader.close();
        	} catch (IOException e) {
            	e.printStackTrace();
            }
			return aqrTXT;
        }
        
 }



