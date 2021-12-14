package salvar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import jogo.Jogo;

public class LoadJogo {
	
	private static Jogo jogo;
	private File arq;
	
	public static Jogo LoadJogo() {

        InputStream file;
       try {
    	   SalveEstado state = new SalveEstado(jogo);
           file = new FileInputStream("./Teste.obj");
           InputStream buffer = new BufferedInputStream(file);
           ObjectInput input = new ObjectInputStream (buffer);
           state = (SalveEstado)input.readObject();
           jogo = state.getJogo();
           input.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
	return jogo;

   }
}
