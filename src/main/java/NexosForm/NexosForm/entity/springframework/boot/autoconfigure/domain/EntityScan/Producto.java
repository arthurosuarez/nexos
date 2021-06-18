package NexosForm.NexosForm.entity.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
public class Producto {

	@Id
	private Integer id;
	
	private String codigo;

	private String nombre;
	
	private Double precio;

	public Producto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
