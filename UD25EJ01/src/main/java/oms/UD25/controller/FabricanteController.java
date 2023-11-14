package oms.UD25.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oms.UD25.dto.Fabricante;
import oms.UD25.services.FabricanteServiceImpl;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

	@Autowired
	FabricanteServiceImpl fabricanteServiceImpl;
	
	@GetMapping("/all")
	public List<Fabricante> listarFabricantes(){
		return fabricanteServiceImpl.listarFabricantes();
	}
	
	
	@PostMapping("/add")
	public Fabricante salvarFabricante(@RequestBody Fabricante fabricante) {
		
		return fabricanteServiceImpl.guardarFabricante(fabricante);
	}
	
	
	@GetMapping("/{codigo}")
	public Fabricante fabricanteXID(@PathVariable(name="codigo") Integer id) {
		
		Fabricante fabricante_xid= new Fabricante();
		
		fabricante_xid=fabricanteServiceImpl.fabricanteXID(id);
		
		System.out.println("Fabricante XID: "+fabricante_xid);
		
		return fabricante_xid;
	}
	
	@PutMapping("/{codigo}")
	public Fabricante actualizarFabricante(@PathVariable(name="codigo")Integer id,@RequestBody Fabricante fabricante) {
		
		Fabricante fabricante_seleccionado= new Fabricante();
		Fabricante fabricante_actualizado= new Fabricante();
		
		fabricante_seleccionado= fabricanteServiceImpl.fabricanteXID(id);
		
		fabricante_seleccionado.setNombre(fabricante.getNombre());
		
		fabricante_actualizado = fabricanteServiceImpl.actualizarFabricante(fabricante_seleccionado);
		
		System.out.println("El fabricante actualizado es: "+ fabricante_actualizado);
		
		return fabricante_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eliminarFabricante(@PathVariable(name="codigo")Integer id) {
		fabricanteServiceImpl.eliminarFabricante(id);
		System.out.println("Fabricante eliminado");
	}
}
