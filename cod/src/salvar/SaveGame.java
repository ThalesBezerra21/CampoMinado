package salvar;

import java.io.*;

import exeption.InputInvalidaExeption;
import jogo.Jogo;

public class SaveGame {

	private static Jogo jogo;
	private File arq;

	public SaveGame(Jogo jogo) {
		
		this.arq = jogo.getArq();
		try {
			SalveEstado state = new SalveEstado(jogo);
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