package oms.UD25.services;

import java.util.List;

import oms.UD25.dto.Fabricante;

public interface IFabricanteService {
	//Metodos del CRUD
	public List<Fabricante> listarFabricantes(); //Listar All 
	
	public Fabricante guardarFabricante(Fabricante fabricante);	//Guarda un video CREATE
	
	public Fabricante fabricanteXID(int id); //Leer datos de un video READ
	
	public Fabricante actualizarFabricante(Fabricante fabricante); //Actualiza datos del video UPDATE
	
	public void eliminarFabricante(int id);// Elimina el video DELETE
}
