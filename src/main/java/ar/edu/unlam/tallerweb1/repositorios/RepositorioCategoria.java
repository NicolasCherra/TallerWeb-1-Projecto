package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Categoria;

public interface RepositorioCategoria {
	Categoria buscarTipoCategoria(String tipo);
	Categoria buscarCategoria(Categoria categoria);
	Boolean guardarCategoria(Categoria categoria);
	Boolean borrarCategoria(Categoria categoria);
	Boolean modificarCategoria(Categoria categoria);
}
