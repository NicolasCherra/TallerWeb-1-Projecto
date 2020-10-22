package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Categoria;

public interface ServicioCategoria {
	Categoria buscarTipoCategoria(String tipo);
	Categoria buscarCategoria(Categoria categoria);
	Boolean guardarCategoria(Categoria categoria);
	Boolean borrarCategoria(Categoria categoria);
	Boolean modificarCategoria(Categoria categoria);
}
