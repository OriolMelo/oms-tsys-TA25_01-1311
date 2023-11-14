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

import oms.UD25.dto.Articulo;
import oms.UD25.services.ArticuloServiceImpl;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
	@Autowired
	ArticuloServiceImpl articuloServiceImpl;
	
	@GetMapping("/all")
	public List<Articulo> listarArticulos(){
		return articuloServiceImpl.listarArticulos();
	}
	
	
	@PostMapping("/add")
	public Articulo salvarArticulo(@RequestBody Articulo articulo) {
		
		return articuloServiceImpl.guardarArticulo(articulo);
	}
	
	
	@GetMapping("/{codigo}")
	public Articulo articuloXID(@PathVariable(name="codigo") Integer id) {
		
		Articulo articulo_xid= new Articulo();
		
		articulo_xid=articuloServiceImpl.articuloXID(id);
		
		System.out.println("Articulo XID: "+articulo_xid);
		
		return articulo_xid;
	}
	
	@PutMapping("/{codigo}")
	public Articulo actualizarArticulo(@PathVariable(name="codigo")Integer id,@RequestBody Articulo articulo) {
		
		Articulo articulo_seleccionado= new Articulo();
		Articulo articulo_actualizado= new Articulo();
		
		articulo_seleccionado= articuloServiceImpl.articuloXID(id);
		
		articulo_seleccionado.setNombre(articulo.getNombre());
		articulo_seleccionado.setPrecio(articulo.getPrecio());
		articulo_seleccionado.setFabricante(articulo.getFabricante());
		
		articulo_actualizado = articuloServiceImpl.actualizarArticulo(articulo_seleccionado);
		
		System.out.println("El articulo actualizado es: "+ articulo_actualizado);
		
		return articulo_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eliminarArticulo(@PathVariable(name="codigo")Integer id) {
		articuloServiceImpl.eliminarArticulo(id);
		System.out.println("Articulo eliminado");
	}
}
