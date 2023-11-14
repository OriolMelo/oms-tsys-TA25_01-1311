package oms.UD25.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oms.UD25.dao.IArticuloDAO;
import oms.UD25.dto.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService{
	@Autowired
	IArticuloDAO iArticuloDAO;
	
	@Override
	public List<Articulo> listarArticulos() {
		
		return iArticuloDAO.findAll();
	}
	
	@Override
	public Articulo guardarArticulo(Articulo articulo) {
		
		return iArticuloDAO.save(articulo);
	}

	@Override
	public Articulo articuloXID(int id) {
		
		return iArticuloDAO.findById(id).get();
	}

	@Override
	public Articulo actualizarArticulo(Articulo articulo) {
		
		return iArticuloDAO.save(articulo);
	}

	@Override
	public void eliminarArticulo(int id) {
		
		iArticuloDAO.deleteById(id);
		
	}
}
