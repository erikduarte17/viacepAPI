package modelo;

public class CEP {

	private int cep;
	private String rua;
	private String bairro;
	private String cidadeEstado;

	public CEP(CEPRecord CEPRecord) {
		this.cep = Integer.valueOf(CEPRecord.cep().replace("-", ""));
		this.rua = CEPRecord.logradouro();
		this.bairro = CEPRecord.bairro();
		this.cidadeEstado = CEPRecord.localidade() + " - " + CEPRecord.uf();
	}

	public int getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidadeEstado() {
		return cidadeEstado;
	}
	
	@Override
	public String toString() {
		return this.rua + " - " + this.bairro + " - " + this.cidadeEstado + ", " + this.cep;
	}

}
