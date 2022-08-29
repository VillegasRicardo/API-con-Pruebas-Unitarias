package back1dia9.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back1dia9.entity.Producto;
import back1dia9.repository.ProductoRepository;

@Service
public class ProductoSevice {

	@Autowired
	private ProductoRepository repoProducto;
	
	
	    //C
		public Producto guardar(Producto producto) {
			return repoProducto.save(producto);
		}
	
	    //R	- OK
		public List<Producto> buscarTodos() {
			return repoProducto.findAll();
		}
		//U
		
		public Producto modificar(int idProducto, Producto producto) {
			// TODO Auto-generated method stub
			Producto produc = repoProducto.findById(idProducto)
	        		.orElseThrow(() -> new ResourceNotFoundException("No existe el registro con id: " + idProducto));        
			produc.setIdcategoria(producto.getIdcategoria());
			produc.setLote(producto.getLote());
			produc.setFechaCaduca(producto.getFechaCaduca());
	        
	        return repoProducto.save(produc); 
		}
		
		//D - OK		
		public void eliminar(int idProducto) {
			repoProducto.deleteById(idProducto);		
		}
		
		// - OK
		public Optional<Producto> buscarCategoria(int idProducto) {
			return repoProducto.findById(idProducto);
		}
	
}
