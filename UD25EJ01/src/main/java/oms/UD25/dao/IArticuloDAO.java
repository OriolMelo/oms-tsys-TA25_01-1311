package oms.UD25.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import oms.UD25.dto.Articulo;

public interface IArticuloDAO extends JpaRepository<Articulo, Integer>{
	
}
