package com.crea_chet.crea_chet.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_direccion")
    private Long id;
    
    @Column(name="nombre", length=45, nullable=false, unique=false)
    private String nombre;
    
    @Column(name="apellidoP", length=45, nullable=false, unique=false)
    private String apellidoP;
    
    @Column(name="apellidoM", length=45, nullable=false, unique=false)
    private String apellidoM;
    
    @Column(name="codigo_postal", length=5, nullable=false, unique=false)
    private String codigoPostal;
    
    @Column(name="estado", length=45, nullable=false, unique=false)
    private String estado;
    
    @Column(name="municipio_alcaldia", length=45, nullable=false, unique=false)
    private String municipioAlcaldia;
    
    @Column(name="colonia", length=45, nullable=false, unique=false)
    private String colonia;
    
    @Column(name="calle_principal", length=45, nullable=false, unique=false)
    private String callePrincipal;
    
    @Column(name="numero_exterior", length=10, nullable=false, unique=false)
    private String numeroExterior;
    
    @Column(name="calle_1", length=45, nullable=false, unique=false)
    private String calle1;
    
    @Column(name="calle_2", length=45, nullable=false, unique=false)
    private String calle2;
    
    @Enumerated(EnumType.STRING)
    @Column(name="residencia_laboral", length=20, nullable=false, unique=false)
    private TipoResidencia residenciaLaboral;
    
    @Column(name="referencia", length=45, nullable=true, unique=false)
    private String referencia;
    
    @Column(name="cel_contacto", length=10, nullable=false, unique=false)
    private String celContacto;
    
    //UNO A UNO CON PEDIDO
    /*@OneToOne(mappedBy = "direccion")
    private Pedido pedido;*/
    
    //FK id_usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
	@JsonBackReference
    private Usuario usuario;
    //FK recididas
    @OneToOne(mappedBy = "direccion")
    private Pedido pedido;
    
    
    // Constructor vacío
    public Direccion() {}


	public Direccion(Long id, String nombre, String apellidoP, String apellidoM, String codigoPostal, String estado,
			String municipioAlcaldia, String colonia, String callePrincipal, String numeroExterior, String calle1,
			String calle2, TipoResidencia residenciaLaboral, String referencia, String celContacto, Usuario usuario,
			Pedido pedido) {
		this.id = id;
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
		this.municipioAlcaldia = municipioAlcaldia;
		this.colonia = colonia;
		this.callePrincipal = callePrincipal;
		this.numeroExterior = numeroExterior;
		this.calle1 = calle1;
		this.calle2 = calle2;
		this.residenciaLaboral = residenciaLaboral;
		this.referencia = referencia;
		this.celContacto = celContacto;
		this.usuario = usuario;
		this.pedido = pedido;
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


	public String getApellidoP() {
		return apellidoP;
	}


	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}


	public String getApellidoM() {
		return apellidoM;
	}


	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getMunicipioAlcaldia() {
		return municipioAlcaldia;
	}


	public void setMunicipioAlcaldia(String municipioAlcaldia) {
		this.municipioAlcaldia = municipioAlcaldia;
	}


	public String getColonia() {
		return colonia;
	}


	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	public String getCallePrincipal() {
		return callePrincipal;
	}


	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}


	public String getNumeroExterior() {
		return numeroExterior;
	}


	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}


	public String getCalle1() {
		return calle1;
	}


	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}


	public String getCalle2() {
		return calle2;
	}


	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}


	public TipoResidencia getResidenciaLaboral() {
		return residenciaLaboral;
	}


	public void setResidenciaLaboral(TipoResidencia residenciaLaboral) {
		this.residenciaLaboral = residenciaLaboral;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public String getCelContacto() {
		return celContacto;
	}


	public void setCelContacto(String celContacto) {
		this.celContacto = celContacto;
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
		return "Direccion [id=" + id + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM
				+ ", codigoPostal=" + codigoPostal + ", estado=" + estado + ", municipioAlcaldia=" + municipioAlcaldia
				+ ", colonia=" + colonia + ", callePrincipal=" + callePrincipal + ", numeroExterior=" + numeroExterior
				+ ", calle1=" + calle1 + ", calle2=" + calle2 + ", residenciaLaboral=" + residenciaLaboral
				+ ", referencia=" + referencia + ", celContacto=" + celContacto + ", usuario=" + usuario + ", pedido="
				+ pedido + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(apellidoM, apellidoP, calle1, calle2, callePrincipal, celContacto, codigoPostal, colonia,
				estado, id, municipioAlcaldia, nombre, numeroExterior, pedido, referencia, residenciaLaboral, usuario);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		return Objects.equals(apellidoM, other.apellidoM) && Objects.equals(apellidoP, other.apellidoP)
				&& Objects.equals(calle1, other.calle1) && Objects.equals(calle2, other.calle2)
				&& Objects.equals(callePrincipal, other.callePrincipal)
				&& Objects.equals(celContacto, other.celContacto) && Objects.equals(codigoPostal, other.codigoPostal)
				&& Objects.equals(colonia, other.colonia) && Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id) && Objects.equals(municipioAlcaldia, other.municipioAlcaldia)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(numeroExterior, other.numeroExterior)
				&& Objects.equals(pedido, other.pedido) && Objects.equals(referencia, other.referencia)
				&& residenciaLaboral == other.residenciaLaboral && Objects.equals(usuario, other.usuario);
	}

    // Constructor con parámetros
  
}
