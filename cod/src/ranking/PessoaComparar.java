package ranking;

import java.util.Comparator;

public class PessoaComparar implements Comparator{

public int compare(Object o1, Object o2){
    Pessoa p1 = (Pessoa) o1;
    Pessoa p2 = (Pessoa) o2;

    return p2.getTempo() - p1.getTempo();
}
}

  