package lp2.projetofinal.entidades;

public class BluRay extends Item { // decidir se pode ser abstrata;
	private int duracao;
	private ClassificacaoBluRay classificacao = ClassificacaoBluRay.LIVRE;

	public BluRay(String nome, double preco, int duracao, String classificacao) {
		super(nome, preco);
		this.duracao = duracao;
	}

	// colecaoDeBluRays
	// duracaoDaTemporada
	// classificacaoEnum

}
