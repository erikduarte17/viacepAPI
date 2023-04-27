package comunicacao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelo.CEP;
import modelo.CEPRecord;
import service.HttpService;
import service.ReadService;

public class Comunicacao {

	public static void main(String[] args) throws IOException, InterruptedException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Set<CEP> enderecos = new HashSet<>();
		ReadService read = new ReadService();
		HttpService service = new HttpService();

		while (true) {

			String leitura = read.leDados();
			if(leitura.equals("sair")) {
				break;
			}
			String address = "https://viacep.com.br/ws/" + leitura + "/json/";

			CEPRecord cepRecord = gson.fromJson(service.iniciaComunicacaoHTTP(address), CEPRecord.class);
			System.out.println(cepRecord);
			enderecos.add(new CEP(cepRecord));
		}
		
		FileWriter writer = new FileWriter("src\\enderecos.txt");
		writer.write(gson.toJson(enderecos));
		
		writer.close();
	}

}
