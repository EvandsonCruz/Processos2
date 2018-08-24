package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Controller {

	public Controller() {
		super();
	}

	public static void listar(String so) {
		if (so.contains("Windows")) {

			String comando = "TASKLIST /FO TABLE";
			try {
				Process proc = Runtime.getRuntime().exec(comando);
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			} catch (IOException e) {
				String erro = e.getMessage();
				JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		if (so.contains("Linux")) {

			String comando = "ps aux";
			try {
				Process proc = Runtime.getRuntime().exec(comando);
				InputStream fluxo = proc.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			} catch (IOException e) {
				String erro = e.getMessage();
				JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}

	}

}
