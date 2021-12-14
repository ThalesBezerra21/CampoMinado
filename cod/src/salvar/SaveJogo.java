package salvar;

import java.io.*;

import exeption.InputInvalidaExeption;
import jogo.Jogo;

public class SaveJogo {

	private static Jogo jogo;
	private File arq;

	public SaveJogo(Jogo jogo) {
		
		this.arq = jogo.getArq();
		try {
			SalvarEstado state = new SalvarEstado(jogo);
			OutputStream arq = new FileOutputStream("./Teste.obj");
			OutputStream buffer = new BufferedOutputStream(arq);
			ObjectOutput output = new ObjectOutputStream(buffer);
			output.writeObject(state);
			output.flush();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
}