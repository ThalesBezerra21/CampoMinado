package ranking;

import java.util.*;

public class Ranking{
    private static final int RANK_MAX = 5;
    
    private static TreeSet<Pessoa> ranking = new TreeSet<Pessoa>(new PessoaComparar());

    private void rankear(Pessoa p){
            // Adicionar pessoa
            ranking.add(p);

            if(ranking.size() > RANK_MAX);
            ranking.remove(ranking.last());;
           
        }   

        public void add(Pessoa p){
            List<String> ranking = new ArrayList<String>();

        }
        public TreeSet<Pessoa> getRanking(){
           return ranking;
        }
 }



