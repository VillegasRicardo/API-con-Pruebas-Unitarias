package back1dia9.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id_producto")
	private Integer idproducto;
		
	@ManyToOne
	@JoinColumn(name="id_categoria", nullable = false, foreignKey = @ForeignKey(name="categoria_id_categoria_FK"))
	private Categoria idcategoria;
	
	@Column(nullable = false, length = 10)
	private String lote;
	
	@Column(name="fecha_caduca", nullable = false)
	private LocalDate fechaCaduca;

		
	/**
	 * @return the idproducto
	 */
	public Integer getIdproducto() {
		return idproducto;
	}

	/**
	 * @param idproducto the idproducto to set
	 */
	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	/**
	 * @return the idcategoria
	 */
	public Categoria getIdcategoria() {
		return idcategoria;
	}

	/**
	 * @param idcategoria the idcategoria to set
	 */
	public void setIdcategoria(Categoria idcategoria) {
		this.idcategoria = idcategoria;
	}

	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}

	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}

	/**
	 * @return the fechaCaduca
	 */
	public LocalDate getFechaCaduca() {
		return fechaCaduca;
	}

	/**
	 * @param fechaCaduca the fechaCaduca to set
	 */
	public void setFechaCaduca(LocalDate fechaCaduca) {
		this.fechaCaduca = fechaCaduca;
	}
	
}
