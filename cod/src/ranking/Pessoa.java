package ranking;

public class Pessoa{

    private final int pontuacao;
    private final String nome;

    public Pessoa(int pontuacao, String nome){
        this.pontuacao = pontuacao;
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public int getPontuacao(){
        return pontuacao;
    }

    public boolean equals(Object o){
        if(o instanceof Pessoa){
            Pessoa aPessoa = (Pessoa) o;
            return aPessoa.nome.equals(nome);
        }

        return false;
    }

    public String toString(){
        return  nome+" ( "+pontuacao+" ) ";
    }
    }
