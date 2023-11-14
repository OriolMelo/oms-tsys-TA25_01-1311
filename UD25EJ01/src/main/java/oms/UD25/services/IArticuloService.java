package oms.UD25.services;

import java.util.List;

import oms.UD25.dto.Articulo;

public interface IArticuloService {
	//Metodos del CRUD
		public List<Articulo> listarArticulos(); //Listar All 
		
		public Articulo guardarArticulo(Articulo articulo);	//Guarda un video CREATE
		
		public Articulo articuloXID(int id); //Leer datos de un video READ
		
		public Articulo actualizarArticulo(Articulo articulo); //Actualiza datos del video UPDATE
		
		public void eliminarArticulo(int id);// Elimina el video DELETE
}
