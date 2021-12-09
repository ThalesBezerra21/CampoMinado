package salvar;



import java.io.*;

import exeption.InputInvalidaExeption;
import jogo.Jogo;

public class SaveGame {

	private Jogo jogo;
	private File arq;

	public SaveGame(Jogo jogo) {
		arq = new File("./cod/test.obj");

		try {
			// Cria novo arquivo
			if (!arq.exists()) {
				// cria um arquivo (vazio)
				arq.createNewFile();
			}
			// Deleta arquivo
			// arq.delete();

		} catch (IOException io) {
			io.printStackTrace();
			throw new InputInvalidaExeption("Esse arquivo não existe");
		}
		ObjectOutputStream obj;
		try {
			obj = new ObjectOutputStream(new FileOutputStream(arq, true));
            obj.writeObject(jogo);
            obj.close();
		}catch (IOException e) {
			e.printStackTrace();
		}    
	}


	public Jogo LoadGame() {
		return jogo;
	}
	

}
