package mx.com.gm.domain;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="persona")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_persona;
	
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
			
	public Persona(String nombre, String apellido, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public void setid_persona(Long id_persona) {
		this.id_persona = id_persona;
	}
	public Long getId_persona() {
		return id_persona;
	}	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
