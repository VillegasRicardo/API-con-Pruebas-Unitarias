package back1dia9.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back1dia9.entity.Categoria;
import back1dia9.repository.CategoriaRepository;

@Service
public class CategoriaSevice {

	@Autowired
	private CategoriaRepository repoCategoria;
	
	
	//C
	public Categoria guardar(Categoria categoria) {
		return repoCategoria.save(categoria);
	}
    //R	
	public List<Categoria> buscarTodos() {
		return repoCategoria.findAll();
	}
	//U
	public Categoria modificar(int idcategoria, Categoria categoria) {
		// TODO Auto-generated method stub
		Categoria actCte = repoCategoria.findById(idcategoria)
        		.orElseThrow(() -> new ResourceNotFoundException("No existe el registro con id: " + idcategoria));        
		actCte.setIdcategoria(categoria.getIdcategoria());
		actCte.setDescripcion(categoria.getDescripcion());
        actCte.setTamanio(categoria.getTamanio());
        
        return repoCategoria.save(actCte); 
	}
	//D
	public void eliminar(int idCategoria) {
		 repoCategoria.deleteById(idCategoria);		
	}
	
	public Optional<Categoria> buscarCategoria(int idCategoria) {
		return repoCategoria.findById(idCategoria);
	}
	
}
