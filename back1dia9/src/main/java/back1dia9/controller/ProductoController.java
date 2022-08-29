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

import back1dia9.entity.Producto;
import back1dia9.service.ProductoSevice;

@RestController
@RequestMapping("/v1/producto")
public class ProductoController {

	
	@Autowired
	private ProductoSevice serviceProducto;
	
	
	    //C
		@PostMapping()
		public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
		    try {
		    	serviceProducto.guardar(producto);
		      return new ResponseEntity<>(null, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	
		//R		
		@GetMapping()
		public ResponseEntity<List<Producto>> buscarTodos(@RequestParam(required = false) String producto) {
			try {			   
				List<Producto> cta = new ArrayList<Producto>();				
					if(producto== null) {
						serviceProducto.buscarTodos().forEach(cta::add);
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
		
		//U
		@PutMapping(path = "/{id}")
		public ResponseEntity<HttpStatus> Update(@PathVariable("id") int idProducto, @RequestBody Producto producto) {
			try {
				Optional<Producto> cat = serviceProducto.buscarCategoria(idProducto);
				if (cat.isPresent()) {
					serviceProducto.modificar(idProducto, producto);
					return new ResponseEntity<>(null, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//D		
		@DeleteMapping(path = "/{id}") 
		public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") int idProducto) {
		    try {	    	
		    	Optional<Producto> cat = serviceProducto.buscarCategoria(idProducto);	    	
		    	if (cat.isPresent()) {
		    		serviceProducto.eliminar(idProducto);
					return new ResponseEntity<>(null, HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
	
	
	
	
}
