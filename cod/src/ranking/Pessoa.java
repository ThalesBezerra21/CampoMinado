package ranking;

public class Pessoa{

    private final int tempo;
    private final String nome;

    public Pessoa(int tempo, String nome){
        this.tempo = tempo;
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public int getTempo(){
        return tempo;
    }

    public boolean equals(Object o){
        if(o instanceof Pessoa){
            Pessoa aPessoa = (Pessoa) o;
            return aPessoa.nome.equals(nome);
        }

        return false;
    }

    public int hashCode(){
        return nome.hashCode();
    }

    public String toString(){
        return  nome+" ( "+tempo+" ) ";
    }
    }
