package br.com.showmilhao.model;

public class Pergunta {
	
	//private int id;
	private String titulo;
	
	private String alternativa1;
	private String alternativa2;
	private String alternativa3;
	private String alternativa4;
	private String alternativa5;

	private String alternativa_correta;
	
	private String pontuacao;
	
	
/*	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/    
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAlternativa_correta() {
		return alternativa_correta;
	}
	public void setAlternativa_correta(String alternativa_correta) {
		this.alternativa_correta = alternativa_correta;
	}
	public String getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}
	public String getAlternativa1() {
		return alternativa1;
	}
	public void setAlternativa1(String alternativa1) {
		this.alternativa1 = alternativa1;
	}
	public String getAlternativa2() {
		return alternativa2;
	}
	public void setAlternativa2(String alternativa2) {
		this.alternativa2 = alternativa2;
		
	}
	public String getAlternativa3() {
		return alternativa3;
	}
	public void setAlternativa3(String alternativa3) {
		this.alternativa3 = alternativa3;
	}
	public String getAlternativa4() {
		return alternativa4;
	}
	public void setAlternativa4(String alternativa4) {
		this.alternativa4 = alternativa4;
	}
	public String getAlternativa5() {
		return alternativa5;
	}
	public void setAlternativa5(String alternativa5) {
		this.alternativa5 = alternativa5;
	}


}
