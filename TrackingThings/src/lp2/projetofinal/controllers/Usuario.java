package lp2.projetofinal.controllers;

/**
 * Classe responsavel por conter metodos e atributos de um objeto do tipo Usuario (Usuario representa na vida real um usuario do Traking Things). Compoe ControllerUsuario.
 * 
 * Laboratorio de Programacao 2 - Projeto Final Parte 01
 * 
 * @author Thiago Santos de Moura - 116210967
 * @author Gabriel Almeida Azevedo - 116210009
 * @author Marcelo Gabriel dos Santos Queiroz Vitorino - 116211290
 */

import java.util.HashMap;
import java.util.Map;

import lp2.projetofinal.entidades.BluRayFilme;
import lp2.projetofinal.entidades.BluRaySerie;
import lp2.projetofinal.entidades.BluRayShow;
import lp2.projetofinal.entidades.Item;
import lp2.projetofinal.entidades.JogoEletronico;
import lp2.projetofinal.entidades.JogoTabuleiro;
import lp2.projetofinal.util.Exceptions;

public class Usuario {

	private String nome;

	private String email;

	private String telefone;

	private Map<String, Item> itens;

	public Usuario(String nome, String email, String telefone) {

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		itens = new HashMap<String, Item>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return this.nome + ", " + this.email + ", " + this.telefone;
	}
	
	private void verificaExistenciaItem(String chave) {

		if (!this.itens.containsKey(chave))
			Exceptions.itemNaoEncontradoException();
	}

	public void adicionaItem(String nomeItem, double preco, String plataforma) {

		JogoEletronico jogoEletronico = new JogoEletronico(nomeItem, preco, plataforma);
		itens.put(nomeItem, jogoEletronico);

	}

	public void adicionaItem(String nomeItem, double preco) {

		JogoTabuleiro jogoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		itens.put(nomeItem, jogoTabuleiro);

	}

	public void adicionaItem(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int anoLancamento) {

		BluRayFilme bluRayFilme = new BluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		itens.put(nomeItem, bluRayFilme);
	}

	public void adicionaItem(String nomeItem, double preco, int duracao, int numeroFaixas, String artista,
			String classificacao) {

		BluRayShow bluRayShow = new BluRayShow(nomeItem, preco, duracao, classificacao, artista, numeroFaixas);
		itens.put(nomeItem, bluRayShow);

	}

	public void adicionaItem(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {

		BluRaySerie bluRaySerie = new BluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero,
				temporada);
		itens.put(nomeItem, bluRaySerie);
	}

	public void adicionarBluRayEpisodio(String BlurayTemporada, int duracao) {

		verificaExistenciaItem(BlurayTemporada);
		
		BluRaySerie bluraySerie = (BluRaySerie) itens.get(BlurayTemporada);
		bluraySerie.adicionarBluRay(duracao);
	}

	public void cadastrarPecaPerdidaNoTabuleiro(String nomeItem, String nomePeca) {

		verificaExistenciaItem(nomeItem);
		
		JogoTabuleiro jogoTabuleiro = (JogoTabuleiro) itens.get(nomeItem);
		jogoTabuleiro.adicionarPecaPerdida(nomePeca);

	}

	public void atualizarItem(String nomeItem, String atributo, String valor) {
		
		verificaExistenciaItem(nomeItem);

		Item item = itens.get(nomeItem);
		item.atualizar(atributo, valor);
		
		if(atributo.equals("Nome")){
			itens.put(valor, item);
			itens.remove(nomeItem);
		}
	}

	public String getInfoItem(String nomeItem, String atributo) {
		
		verificaExistenciaItem(nomeItem);
		
		Item item = itens.get(nomeItem);
		return item.getInfo(atributo);

	}

	public void removerItem(String nomeItem) {

		verificaExistenciaItem(nomeItem);
		
		itens.remove(nomeItem);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario ref = (Usuario) obj;

		if (!ref.getNome().equals(this.nome))
			return false;
		if (!ref.getTelefone().equals(this.telefone))
			return false;

		return true;
	}

}