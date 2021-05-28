package application;

import java.io.IOException;

import controller.ArquivosControllerFunc;

public class Principal {

	public static void main(String[] args) {
		var aController = new ArquivosControllerFunc();
		String path = "C:\\exemplo";
		String nome = "in.txt";
		String arqNovo = "TesteAula.txt";
		
		try {
			//aController.abrirArquivo(path, nome);
			aController.criarArquivo(path, arqNovo);
			aController.leArquivo(path, arqNovo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
