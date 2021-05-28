package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

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
		var arq = new File(path, nome);
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			String conteudo = geraTxt();
			var fileWriter = new FileWriter(arq,existe);
			var print = new PrintWriter(fileWriter);
			print.write(conteudo+"\n");
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório não existe");
		}
	}

	private String geraTxt() {
		var buffer = new StringBuffer();
		String linha = "";
		while(!linha.equalsIgnoreCase("fim")) {
			linha = JOptionPane.showInputDialog(null, "Digite uma frase","Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
			if (!linha.equalsIgnoreCase("fim")) {
				buffer.append(linha);
			}
		}
		return buffer.toString();
	}

	@Override
	public void leArquivo(String path, String nome) throws IOException {
		var arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			var fluxo = new FileInputStream(arq);
			var leitor = new InputStreamReader(fluxo);
			var buffer = new BufferedReader(leitor);
			var linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}
		else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void abrirArquivo(String path, String nome) throws IOException {
		var arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			var desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

}
