package salvar;

import java.io.*;

import exeption.InputInvalidaExeption;
import jogo.Jogo;

public class SaveGame {

	private Jogo jogo;
	private File arq;
	
	public SaveGame(Jogo jogo) {

		try {
			OutputStream arq = new FileOutputStream("./cod/test.obj");
			OutputStream buffer = new BufferedOutputStream(arq);
			ObjectOutput output = new ObjectOutputStream(buffer);
			output.writeObject(jogo);
			// output.flush();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void CriaArquivo() throws InputInvalidaExeption{
	try{
		// Cria novo arquivo
		if (!arq.exists()) {
			// cria um arquivo (vazio)
			arq.createNewFile();
		}
	}catch(IOException io){
			io.printStackTrace();
			throw new InputInvalidaExeption("Esse arquivo não existe");
			}
	}
	
	public void deleteArquivo() {
		arq.delete();
	}

	public Jogo LoadGame() {
		try {
			InputStream arq = new FileInputStream("./cod/test.obj");
			InputStream buffer = new BufferedInputStream(arq);
			ObjectInput input = new ObjectInputStream(buffer);
			this.jogo = (Jogo) input;
			input.close();

		} catch (IOException e) {
			e.printStackTrace();

		}
		return jogo;
	}

}