package lp2.projetofinal.entidades;

import lp2.projetofinal.interfaces.CartaoFidelidade;

public class CartaoBomAmigo implements CartaoFidelidade{

	@Override
	public boolean permisaoPegarEmprestao() {

		return true;
	}

	@Override
	public int prazoEmprestimo() {

		return 14;
	}

	@Override
	public String getNomeCartao(){
		return "BomAmigo";
	}

}