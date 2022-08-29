package back1dia9.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import back1dia9.entity.Categoria;
import back1dia9.service.CategoriaSevice;

@RestController
@RequestMapping("/v1/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaSevice serviceCategoria;
	
	//C - X
	@PostMapping()
	public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria) {
	    try {
	    	serviceCategoria.guardar(categoria);
	      return new ResponseEntity<>(null, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
    //R	- OK
	@GetMapping()
	public ResponseEntity<List<Categoria>> buscarTodos(@RequestParam(required = false) String categoria) {
		try {			   
			List<Categoria> cta = new ArrayList<Categoria>();				
				if(categoria== null) {
					serviceCategoria.buscarTodos().forEach(cta::add);
				}			
				if (cta.isEmpty()) {
				    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				 }					
			return new ResponseEntity<>(cta,HttpStatus.OK);					
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}				
	}
	//U - OK
	@PutMapping(path = "/{id}")
	public ResponseEntity<HttpStatus> Update(@PathVariable("id") int idCategoria, @RequestBody Categoria categoria) {
		try {
			Optional<Categoria> cat = serviceCategoria.buscarCategoria(idCategoria);
			if (cat.isPresent()) {
				serviceCategoria.modificar(idCategoria, categoria);
				return new ResponseEntity<>(null, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//D - OK
	@DeleteMapping(path = "/{id}") 
	public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") int idCategoria) {
	    try {	    	
	    	Optional<Categoria> cat = serviceCategoria.buscarCategoria(idCategoria);	    	
	    	if (cat.isPresent()) {
	    		serviceCategoria.eliminar(idCategoria);
				return new ResponseEntity<>(null, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	

}
