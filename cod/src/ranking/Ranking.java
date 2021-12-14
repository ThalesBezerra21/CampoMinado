package ranking;

import java.io.*;
import java.util.*;

public class Ranking{
	
    private static final int RANK_MAX = 10;  
    private List ranking;
    private Pessoa p;
    private File arq = new File("/Ranking.txt");;

	public void rankear(Pessoa p){
    		//Lista de pessoas
    		List<Pessoa> ranking = new ArrayList<Pessoa>();
    		
            // Adicionar pessoa
            ranking.add(p);

            if(ranking.size() > RANK_MAX);
            ranking.remove(((TreeSet<Pessoa>) ranking).last());;
           
        }   

        public void add(Pessoa p){
            List<String> ranking = new ArrayList<String>();

        }
        
        public void criarRanking() {

            try {
                arq.createNewFile();
                FileWriter fileWriter = new FileWriter(arq, false);
                PrintWriter pW = new PrintWriter(fileWriter);
                pW.print(p.getNome()+" ("+p.getPontuacao()+") ");
                pW.flush();
                pW.close();
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
        private void lerRanking() {

            try {
            	
                FileReader fileReader = new FileReader(arq);
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
        }
        
        public List getRanking(){
           return ranking;
        }
 }



