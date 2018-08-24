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

	public static void kill(String so) {
		if (so.contains("Windows")) {
			String cmdPid = "TASKKILL /PID ";
			String cmdNome = "TASKKILL /IM ";
			String nome;
			int pid;
			int opc = 0;

			do {
				opc = Integer.parseInt(JOptionPane.showInputDialog("Menu\n\n1- Nome\n2- PID\n9- Sair"));
				switch (opc) {

				case 1:
					nome = JOptionPane.showInputDialog("Nome do processo");
					try {
						Process proc = Runtime.getRuntime().exec(cmdNome + nome);

					} catch (IOException e) {
						String erro = e.getMessage();
						JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
					break;
				case 2:
					pid = Integer.parseInt(JOptionPane.showInputDialog("PID do processo"));
					try {
						Process proc = Runtime.getRuntime().exec(cmdPid + pid);

					} catch (IOException e) {
						String erro = e.getMessage();
						JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
					break;
				case 9:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opc inválida");
					break;
				}
			} while (opc != 9);
		}
		
		if (so.contains("Linux")) {
			String cmdPid = "TASKKILL /PID ";
			String cmdNome = "TASKKILL /IM ";
			String nome;
			int pid;
			int opc = 0;

			do {
				opc = Integer.parseInt(JOptionPane.showInputDialog("Menu\n\n1- Nome\n2- PID\n9- Sair"));
				switch (opc) {

				case 1:
					nome = JOptionPane.showInputDialog("Nome do processo");
					try {
						Process proc = Runtime.getRuntime().exec(cmdNome + nome);

					} catch (IOException e) {
						String erro = e.getMessage();
						JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
					break;
				case 2:
					pid = Integer.parseInt(JOptionPane.showInputDialog("PID do processo"));
					try {
						Process proc = Runtime.getRuntime().exec(cmdPid + pid);

					} catch (IOException e) {
						String erro = e.getMessage();
						JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
					break;
				case 9:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opc inválida");
					break;
				}
			} while (opc != 9);
		}
	}
}
