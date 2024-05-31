package com.crea_chet.crea_chet.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/* Para usar JPA en nuestro modelo, debemos de agregar algunos metodos nuevos, automaticamente o agregra anotaciones
 * 	1. Constructor vacio 
 * 	2. hasCode(): 
 * 	3. equals()  
 *-----> Estos metodos nos permiten hacer comparaciones para evitar duplicidad en los objetos a nivel interno.*/
/* Ahora vamos conn las anotaciones para mapear clases
 * 	@Entity: para indicar que esta clase es un entidad OMR, osea que se va a mapear como modelo relacional, para llegar a una tabla en nuestra base de datos
 * 	@Table(name = "tableName", shema = "db")
 * 	@Id : indicar una llave primaria (PK) 
 * 	@GenerateValue() : indica la manera en la que se genera el atributo en la tabla
 * 	@Column : nos permite configurar el atributo de Java con las propiedades que debe tener con la columna de tabla de la DB*/


@Entity
@Table(name = "productos")
public class Producto {
	
	// Aquí definimos el modelo de negocio, atributos de la DB
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "id")
	private Long id;
		
	@Column(name = "nombre", length = 50, nullable = false, unique = true)
	private String nombre;
		
	@Column(name = "descripcion", length = 50, nullable = false, unique = true)
	private String descripcion;
		
	@Column(name = "precio", length = 50, nullable = false, unique = false)
	private Double precio;
		
	@Enumerated(EnumType.STRING) 
	@Column(name = "variacion", length = 2 , nullable = false, unique =false)
	private Variacion variacion;
		
	@Column(name = "stock", nullable = false)
	private Integer stock;
		
	@Column(name = "imagen", length = 255, nullable = false, unique = true)
	private String imagen;
		
	@Enumerated(EnumType.STRING) 
	@Column(name = "categoria", length = 13 , nullable = false, unique =false)
	private Categoria categoria;
	    
	/*  pedido -> productos */
	/*@ManyToOne
    @JoinColumn(name="pedido_id") //Foreing Key
    private Pedido pedido;*/
	//Recibe las conections de FK------------------------------------------
	//FK para carrito y producto
	  @ManyToMany(mappedBy = "productos")
	 
	    private List<Carrito> carritos;
	  
	
	
	/* Constructor vacio*/
	public Producto() {
	}



	public Producto(Long id, String nombre, String descripcion, Double precio, Variacion variacion, Integer stock,
			String imagen, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.variacion = variacion;
		this.stock = stock;
		this.imagen = imagen;
		this.categoria = categoria;
	}



	public Producto(Long id, String nombre, String descripcion, Double precio, Variacion variacion, Integer stock,
			String imagen, Categoria categoria, List<Carrito> carritos) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.variacion = variacion;
		this.stock = stock;
		this.imagen = imagen;
		this.categoria = categoria;
		this.carritos = carritos;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public Variacion getVariacion() {
		return variacion;
	}



	public void setVariacion(Variacion variacion) {
		this.variacion = variacion;
	}



	public Integer getStock() {
		return stock;
	}



	public void setStock(Integer stock) {
		this.stock = stock;
	}



	public String getImagen() {
		return imagen;
	}



	public void setImagen(String imagen) {
		this.imagen = imagen;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public List<Carrito> getCarritos() {
		return carritos;
	}



	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}



	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", variacion=" + variacion + ", stock=" + stock + ", imagen=" + imagen + ", categoria=" + categoria
				+ ", carritos=" + carritos + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(carritos, categoria, descripcion, id, imagen, nombre, precio, stock, variacion);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(carritos, other.carritos) && categoria == other.categoria
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(imagen, other.imagen) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio) && Objects.equals(stock, other.stock)
				&& variacion == other.variacion;
	}

	
	
}
