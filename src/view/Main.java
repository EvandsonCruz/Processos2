package view;

import controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller cont = new Controller();
		String so = System.getProperty("os.name");
		//cont.listar(so);
		cont.kill(so);
	}

}
