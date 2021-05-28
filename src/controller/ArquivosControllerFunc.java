package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivosControllerFunc implements ArquivosController{

	@Override
	public void leDiretorio(String path) throws IOException {
		var dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles().clone();
			for(File f: files) {
				if(f.isFile()) {
					System.out.println("    \t"+f.getName());
				}
				else {
					System.out.println("<DIR>\t"+ f.getName());
				}
			}
			
		} else {
			throw new IOException("Diretório não existe");
		}
	}

	@Override
	public void criarArquivo(String path, String nome) throws IOException {
		var dir = new File(path);
		var arq = new File(path, nome + ".txt");
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			String conteudo = geraTxt();
			var fileWriter = new FileWriter(arq,existe);
			var print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório não existe");
		}
	}

	private String geraTxt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leArquivo(String path, String nome) {
		
	}

	@Override
	public void abrirArquivo(String path, String nome) {
		
	}

}
