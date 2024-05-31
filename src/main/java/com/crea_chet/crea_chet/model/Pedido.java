package com.crea_chet.crea_chet.model;

import java.time.LocalDateTime;

import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private Long id;
	
	
	@Enumerated(EnumType.STRING) 
	@Column(name = "estatus_pedido", length = 13 , nullable = false, unique =false)
	private Estatus_pedido estatus_pedido;
	
	@CreationTimestamp
	@Column(name = "fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime fecha_creacion;
	
	@Column(name="precio_envio", nullable = false)
	private Double precio_envio;
	
	@Column(name="precioTotal")//Total envio + producto
	private Double precioTotal;
	
	/*  LLaver foraneas
	 * carrito
	 * producto
	 * direccion
	 * pago*/
	
	/* Carrito -> Pedido*/
	/*@OneToOne
    @JoinColumn(name="carrito_id", nullable=true, unique= true) //Foreing Key
    private Carrito carrito;*/
	
	/* Conexion producto -> pedido */
    /*@OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> producto;//productos*/
    
    /* Dirección -> Pedido*/
    /*@OneToOne
    @JoinColumn(name="direccion_id", nullable=false, unique= true) //Foreing Key
    private Direccion direccion;*/
    
	/* Pago -> Pedido*/
    /*@OneToOne
    @JoinColumn(name="pago_id", nullable=false, unique= true) //Foreing Key
    private Pago pago;*/
	
	//FK 
//id_Usuario no se si es necesario porque el carrito ya le corresponde a un Usuario
	//Los productos ya viven en carrito 
	//id_Carrito
	@OneToOne
    @JoinColumn(name="carrito_id", nullable=false) //Foreing Key
    private Carrito carrito;
	
    //id_Pago
	@OneToOne
    @JoinColumn(name="pago_id", nullable=false) //Foreing Key
    private Pago pago;
	
	//id_Direccion 
	@OneToOne
    @JoinColumn(name="direccion_id", nullable=false) //Foreing Key
    private Direccion direccion;
	
    /*  Constructor sin parametros*/
	public Pedido() {
	}

	public Pedido(Long id, Estatus_pedido estatus_pedido, LocalDateTime fecha_creacion, Double precio_envio,
			Double precioTotal, Carrito carrito, Pago pago, Direccion direccion) {
		this.id = id;
		this.estatus_pedido = estatus_pedido;
		this.fecha_creacion = fecha_creacion;
		this.precio_envio = precio_envio;
		this.precioTotal = precioTotal;
		this.carrito = carrito;
		this.pago = pago;
		this.direccion = direccion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Estatus_pedido getEstatus_pedido() {
		return estatus_pedido;
	}

	public void setEstatus_pedido(Estatus_pedido estatus_pedido) {
		this.estatus_pedido = estatus_pedido;
	}

	public LocalDateTime getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDateTime fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Double getPrecio_envio() {
		return precio_envio;
	}

	public void setPrecio_envio(Double precio_envio) {
		this.precio_envio = precio_envio;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", estatus_pedido=" + estatus_pedido + ", fecha_creacion=" + fecha_creacion
				+ ", precio_envio=" + precio_envio + ", precioTotal=" + precioTotal + ", carrito=" + carrito + ", pago="
				+ pago + ", direccion=" + direccion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carrito, direccion, estatus_pedido, fecha_creacion, id, pago, precioTotal, precio_envio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(carrito, other.carrito) && Objects.equals(direccion, other.direccion)
				&& estatus_pedido == other.estatus_pedido && Objects.equals(fecha_creacion, other.fecha_creacion)
				&& Objects.equals(id, other.id) && Objects.equals(pago, other.pago)
				&& Objects.equals(precioTotal, other.precioTotal) && Objects.equals(precio_envio, other.precio_envio);
	}

	
	
	
	
}
