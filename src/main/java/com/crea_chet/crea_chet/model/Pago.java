package com.crea_chet.crea_chet.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pago")
public class Pago {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_pago")
	    private Long id_pago;

	    @Column(name = "nombre_tarjeta", length = 100, nullable = false)
	    private String nombre_tarjeta;

	    @Column(name = "numero_tarjeta", length = 16, nullable = false)
	    private String numero_tarjeta;

	    @Column(name = "fecha_expiracion", nullable = false)
	    private String fecha_expiracion;

	    @Column(name = "codigo_seguridad", length = 3, nullable = false)
	    private String codigo_seguridad;
	    
	    
	    /* Pedido -> Pago Uno a uno*/
	    /*@OneToOne(mappedBy = "pago")
	    private Pedido pedido;*/
	    
	    //FK id_Usuario
	    @ManyToOne
	    @JoinColumn(name = "usuario_id")
		@JsonBackReference
	    private Usuario usuario;
	    
	    //FK recibidas
	    @OneToOne(mappedBy = "pago")
	    private Pedido pedido;
	    
	    
		/* Constructor vacio */
		public Pago() {
		}


		public Pago(Long id_pago, String nombre_tarjeta, String numero_tarjeta, String fecha_expiracion,
				String codigo_seguridad, Usuario usuario, Pedido pedido) {
			this.id_pago = id_pago;
			this.nombre_tarjeta = nombre_tarjeta;
			this.numero_tarjeta = numero_tarjeta;
			this.fecha_expiracion = fecha_expiracion;
			this.codigo_seguridad = codigo_seguridad;
			this.usuario = usuario;
			this.pedido = pedido;
		}


		public Long getId_pago() {
			return id_pago;
		}


		public void setId_pago(Long id_pago) {
			this.id_pago = id_pago;
		}


		public String getNombre_tarjeta() {
			return nombre_tarjeta;
		}


		public void setNombre_tarjeta(String nombre_tarjeta) {
			this.nombre_tarjeta = nombre_tarjeta;
		}


		public String getNumero_tarjeta() {
			return numero_tarjeta;
		}


		public void setNumero_tarjeta(String numero_tarjeta) {
			this.numero_tarjeta = numero_tarjeta;
		}


		public String getFecha_expiracion() {
			return fecha_expiracion;
		}


		public void setFecha_expiracion(String fecha_expiracion) {
			this.fecha_expiracion = fecha_expiracion;
		}


		public String getCodigo_seguridad() {
			return codigo_seguridad;
		}


		public void setCodigo_seguridad(String codigo_seguridad) {
			this.codigo_seguridad = codigo_seguridad;
		}


		public Usuario getUsuario() {
			return usuario;
		}


		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}


		public Pedido getPedido() {
			return pedido;
		}


		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}


		@Override
		public String toString() {
			return "Pago [id_pago=" + id_pago + ", nombre_tarjeta=" + nombre_tarjeta + ", numero_tarjeta="
					+ numero_tarjeta + ", fecha_expiracion=" + fecha_expiracion + ", codigo_seguridad="
					+ codigo_seguridad + ", usuario=" + usuario + ", pedido=" + pedido + "]";
		}


		@Override
		public int hashCode() {
			return Objects.hash(codigo_seguridad, fecha_expiracion, id_pago, nombre_tarjeta, numero_tarjeta, pedido,
					usuario);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pago other = (Pago) obj;
			return Objects.equals(codigo_seguridad, other.codigo_seguridad)
					&& Objects.equals(fecha_expiracion, other.fecha_expiracion)
					&& Objects.equals(id_pago, other.id_pago) && Objects.equals(nombre_tarjeta, other.nombre_tarjeta)
					&& Objects.equals(numero_tarjeta, other.numero_tarjeta) && Objects.equals(pedido, other.pedido)
					&& Objects.equals(usuario, other.usuario);
		}


		



		
}
