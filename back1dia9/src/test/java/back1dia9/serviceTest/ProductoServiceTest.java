package back1dia9.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import back1dia9.entity.Categoria;
import back1dia9.entity.Producto;
import back1dia9.service.ProductoSevice;

import org.junit.Ignore;
import org.junit.Test.*;

@SpringBootTest
public class ProductoServiceTest {

	@Autowired
	ProductoSevice productoServiceTest;
	
	
	    // C
		@Test
		void debeGuardarUnRegistroProducto() {
			Producto producto = new Producto();
			Categoria categoria = new Categoria();
			
			categoria.setIdcategoria(1);
			categoria.setDescripcion("Donas de azucar");
			categoria.setTamanio("Pequeñas");
			
			 LocalDate hoy = LocalDate.now();
			
			producto.setIdcategoria(categoria);
			producto.setLote("A202200001");  
			producto.setFechaCaduca(hoy);
			
			Producto producto1 = productoServiceTest.guardar(producto);

			assertThat(producto1.getIdproducto()).isGreaterThan(0);
			
		}
        
		
		// R		
		@Test
		void bebeRegresarTodosProductos() {
			List<Producto> lst = new ArrayList<>();
			List<Producto> result = productoServiceTest.buscarTodos();
			if (result != null) {
				Assertions.assertTrue(true);
			} else {
				Assertions.fail();
			}			
		}
		
		
        
		// U		
	    @Ignore
		@Test
		void debeActualizar() {

	    	Producto producto = productoServiceTest.buscarCategoria(16).get();
	    	
	    	LocalDate hoy = LocalDate.now();
	    	Categoria categoria = new Categoria();
	    	
	    	categoria.setIdcategoria(1);
			categoria.setDescripcion("Donas de azucar");
			categoria.setTamanio("Pequeñas");
	    	
	    	producto.setIdcategoria(categoria);;
	    	producto.setLote("A202200123");;  
	    	producto.setFechaCaduca(hoy);   

			Producto productoUpdate = productoServiceTest.modificar(producto.getIdproducto(), producto);

			assertThat(productoUpdate.getLote()).isEqualTo("A202200123");	    	
	    	
		}

		
		
		// D		
		@Ignore
		@Test
		void debeEliminarUnRegistroCategoria() {
			
			Producto producto = productoServiceTest.buscarCategoria(5).get();
			productoServiceTest.eliminar(producto.getIdproducto());

			Producto producto1 = null;

			Optional<Producto> optionalProducto= productoServiceTest.buscarCategoria(5);

			if (optionalProducto.isPresent()) {
				producto1 = optionalProducto.get();
			}

			assertThat(producto1).isNull();
			
		}
	
	
	
}
