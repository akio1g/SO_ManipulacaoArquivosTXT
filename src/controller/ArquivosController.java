package controller;

import java.io.IOException;

public interface ArquivosController {
	public void leDiretorio(String path) throws IOException;
	public void criarArquivo(String path, String nome) throws IOException;
	public void leArquivo(String path, String nome);
	public void abrirArquivo(String path, String nome);
}
