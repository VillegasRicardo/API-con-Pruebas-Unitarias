package back1dia9.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private Integer idcategoria;
	
	@Column(nullable = false, length = 50)
	private String descripcion;
	
	@Column(nullable = false, length = 10)
	private String tamanio;
	
	
	/**
	 * @return the idcategoria
	 */
	public Integer getIdcategoria() {
		return idcategoria;
	}
	/**
	 * @param idcategoria the idcategoria to set
	 */
	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the tamanio
	 */
	public String getTamanio() {
		return tamanio;
	}
	/**
	 * @param tamanio the tamanio to set
	 */
	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
		

}

