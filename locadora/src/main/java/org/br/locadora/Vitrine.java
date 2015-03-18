package org.br.locadora;

import java.util.ArrayList;
import java.util.List;

public class Vitrine {
	private static List<Produto> produtos = new ArrayList<Produto>();

	public static List<Produto> getProdutos() {
		return produtos;
	}

	public void addProdutos(Produto... ps) {
		for (Produto p : ps)
			produtos.add(p);
	}
}
