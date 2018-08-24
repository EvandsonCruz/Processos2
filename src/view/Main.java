package view;

import javax.swing.JOptionPane;

import controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller cont = new Controller();
		String so = System.getProperty("os.name");
		int opc = 0;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu\n\n1- Listar processos\n2- Matar processos\n9- Sair"));
			switch (opc) {
			case 1:
				cont.listar(so);
				break;
			case 2:
				cont.kill(so);
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
