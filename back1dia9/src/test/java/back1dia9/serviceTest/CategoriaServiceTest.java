package back1dia9.serviceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import back1dia9.entity.Categoria;
import back1dia9.service.CategoriaSevice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test.*;

@SpringBootTest
public class CategoriaServiceTest {

	@Autowired
	CategoriaSevice categoriaServiceTest;

	// C
	@Ignore
	@Test
	void debeGuardarUnRegistroCategoria() {

		Categoria categoria = new Categoria();
		categoria.setDescripcion("Pan Blanco");
		categoria.setTamanio("Grande");

		Categoria categoria1 = categoriaServiceTest.guardar(categoria);

		assertThat(categoria1.getIdcategoria()).isGreaterThan(0);
	}

	// R
	@Ignore
	@Test
	void bebeRegresarTodasCategorias() {
		List<Categoria> lst = new ArrayList<>();
		List<Categoria> result = categoriaServiceTest.buscarTodos();
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

		Categoria categoria = categoriaServiceTest.buscarCategoria(5).get();

		categoria.setDescripcion("Rebanadas");
		categoria.setTamanio("Pequeña");

		Categoria categoriaUpdate = categoriaServiceTest.modificar(categoria.getIdcategoria(), categoria);

		assertThat(categoriaUpdate.getDescripcion()).isEqualTo("Rebanadas");

	}

	// D
	@Ignore
	@Test
	void debeEliminarUnRegistroCategoria() {
		Categoria categoria = categoriaServiceTest.buscarCategoria(9).get();
		categoriaServiceTest.eliminar(categoria.getIdcategoria());

		Categoria categoria1 = null;

		Optional<Categoria> optionalCategoria = categoriaServiceTest.buscarCategoria(9);

		if (optionalCategoria.isPresent()) {
			categoria1 = optionalCategoria.get();
		}

		assertThat(categoria1).isNull();

	}

}
