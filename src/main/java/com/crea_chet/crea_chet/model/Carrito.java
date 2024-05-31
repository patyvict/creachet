package com.crea_chet.crea_chet.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="carrito")
public class Carrito {
	/* id_user
	 * id_pedido 
	 * nombreDelArticulo*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_carrito" )
	private Long id;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	/*@Column(name="precioTotal")//Total envio + productos
	private Double precioTotal;*///se mueve a pedido
	
	@Column(name="precioTotalProductos")//Total Cantidad * precioproducto
	private Double precioTotalProductos;
	
	/*@Column(name="precio_envio", nullable = false)
	private Double precio_envio;*///se mueve a pedido 
	
	/* Relacion uno a uno*/
	/*@OneToOne
    @JoinColumn(name="usuario_id", nullable=false, unique= true) //Foreing Key
    private Usuario usuario;*/
	
	/* Carrito con pedido*/
	/*@OneToOne(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true )
    private Pedido pedido;*/
   //FK
	
	
	
	//id_Usuario 
	@OneToOne
    @JoinColumn(name="usuario_id", nullable=false) //Foreing Key
	 @JsonBackReference
    private Usuario usuario;
	
	//id_Producto mucho a muchos
	@ManyToMany
    @JoinTable(
        name = "carrito_producto",
        joinColumns = @JoinColumn(name = "carrito_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
	 
    private List<Producto> productos;
	
	//fk recibidas
	@OneToOne(mappedBy = "carrito")
    private Pedido pedido;
	
	

	/*  Constructor vacio*/
	public Carrito() {
	}



	public Carrito(Long id, Integer cantidad, Double precioTotalProductos, Usuario usuario, List<Producto> productos,
			Pedido pedido) {
		this.id = id;
		this.cantidad = cantidad;
		this.precioTotalProductos = precioTotalProductos;
		this.usuario = usuario;
		this.productos = productos;
		this.pedido = pedido;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public Double getPrecioTotalProductos() {
		return precioTotalProductos;
	}



	public void setPrecioTotalProductos(Double precioTotalProductos) {
		this.precioTotalProductos = precioTotalProductos;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public List<Producto> getProductos() {
		return productos;
	}



	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	@Override
	public String toString() {
		return "Carrito [id=" + id + ", cantidad=" + cantidad + ", precioTotalProductos=" + precioTotalProductos
				+ ", usuario=" + usuario + ", productos=" + productos + ", pedido=" + pedido + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(cantidad, id, pedido, precioTotalProductos, productos, usuario);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(id, other.id)
				&& Objects.equals(pedido, other.pedido)
				&& Objects.equals(precioTotalProductos, other.precioTotalProductos)
				&& Objects.equals(productos, other.productos) && Objects.equals(usuario, other.usuario);
	}


	/* Constructor con parametros*/

}
