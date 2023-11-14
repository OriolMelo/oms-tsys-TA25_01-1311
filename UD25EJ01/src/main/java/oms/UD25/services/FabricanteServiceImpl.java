package oms.UD25.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import oms.UD25.dto.Fabricante;
import oms.UD25.dao.IFabricanteDAO;

@Service
public class FabricanteServiceImpl implements IFabricanteService{

	@Autowired
	IFabricanteDAO iFabricanteDAO;
	
	@Override
	public List<Fabricante> listarFabricantes() {
		
		return iFabricanteDAO.findAll();
	}
	
	@Override
	public Fabricante guardarFabricante(Fabricante fabricante) {
		
		return iFabricanteDAO.save(fabricante);
	}

	@Override
	public Fabricante fabricanteXID(int id) {
		
		return iFabricanteDAO.findById(id).get();
	}

	@Override
	public Fabricante actualizarFabricante(Fabricante fabricante) {
		
		return iFabricanteDAO.save(fabricante);
	}

	@Override
	public void eliminarFabricante(int id) {
		
		iFabricanteDAO.deleteById(id);
		
	}
}
