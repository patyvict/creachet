package com.crea_chet.crea_chet.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", length = 250, nullable = false, unique = false)
	private String name;

	@Column(name = "last_name", length = 50, nullable = false, unique = false)
	private String lastName;

	@Column(name = "middle_name", length = 50, nullable = true, unique = false)
	private String middleName;

	@Column(name = "phone_number", length = 10, nullable = true, unique = false)
	private String phoneNumber;

	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	@Column(name = "password", length = 10, nullable = false)
	private String password;

	@CreationTimestamp
	@Column(name = "creation_date", nullable = false, updatable = false)
	private LocalDateTime creationDate;


	@Enumerated(EnumType.STRING) 
	@Column(name = "role", length = 13 , nullable = false, unique =false)
	private Role role;

	@Lob
	@Column(name = "profile_image", nullable = true, unique =false)
	private byte[] profileImage;
	
	
	
	/*@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true )
    private Carrito carrito;*/
	//Recibe las conections de FK--------------------------------
	//pago
	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference
    private List<Pago> pagos=new ArrayList<>();
	
	//direccion
	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference
    private List<Direccion> direccion;
	
	//carrito
	 @OneToOne(mappedBy = "usuario")
	 @JsonManagedReference
	    private Carrito carrito;
	
	
	/* Constructor vacio */
	public Usuario() {
	}

	//Constructor 

	public Usuario(Long id, String name, String lastName, String middleName, String phoneNumber, String email,
			String password, LocalDateTime creationDate, Role role, byte[] profileImage) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.role = role;
		this.profileImage = profileImage;
	}



	public Usuario(Long id, String name, String lastName, String middleName, String phoneNumber, String email,
			String password, LocalDateTime creationDate, Role role, byte[] profileImage, List<Pago> pagos,
			List<Direccion> direccion, Carrito carrito) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.middleName = middleName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.role = role;
		this.profileImage = profileImage;
		this.pagos = pagos;
		this.direccion = direccion;
		this.carrito = carrito;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDateTime getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public byte[] getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}


	public List<Pago> getPagos() {
		return pagos;
	}


	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}


	public List<Direccion> getDireccion() {
		return direccion;
	}


	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}


	public Carrito getCarrito() {
		return carrito;
	}


	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + ", creationDate="
				+ creationDate + ", role=" + role + ", profileImage=" + Arrays.toString(profileImage) + ", pagos="
				+ pagos + ", direccion=" + direccion + ", carrito=" + carrito + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(profileImage);
		result = prime * result + Objects.hash(carrito, creationDate, direccion, email, id, lastName, middleName, name,
				pagos, password, phoneNumber, role);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(carrito, other.carrito) && Objects.equals(creationDate, other.creationDate)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(middleName, other.middleName) && Objects.equals(name, other.name)
				&& Objects.equals(pagos, other.pagos) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Arrays.equals(profileImage, other.profileImage)
				&& role == other.role;
	}


	

}
