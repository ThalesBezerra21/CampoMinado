package campoMinado.exeption;

public class InputInvalidaExeption extends IllegalArgumentException{
    public InputInvalidaExeption(String mensagem){
        super(mensagem);
    }
}
