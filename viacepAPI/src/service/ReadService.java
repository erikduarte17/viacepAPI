package service;

import java.util.Scanner;

public class ReadService {

	private Scanner scan = new Scanner(System.in);
	private String read = "";
	
	public String leDados() {
		System.out.println("Entre com CEP a pesquisar: (Digite \"sair\" para encerrar) ");
		read = scan.nextLine();
		return read.replace("-", "");
	}
	
}
