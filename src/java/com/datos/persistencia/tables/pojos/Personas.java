/**
 * This class is generated by jOOQ
 */
package persistencia.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Personas implements Serializable {

	private static final long serialVersionUID = 969435130;

	private Integer personaid;
	private String  nombres;
	private String  apellidos;
	private String  cedula;
	private String  correoelectronico;
	private String  telefono;

	public Personas() {}

	public Personas(Personas value) {
		this.personaid = value.personaid;
		this.nombres = value.nombres;
		this.apellidos = value.apellidos;
		this.cedula = value.cedula;
		this.correoelectronico = value.correoelectronico;
		this.telefono = value.telefono;
	}

	public Personas(
		Integer personaid,
		String  nombres,
		String  apellidos,
		String  cedula,
		String  correoelectronico,
		String  telefono
	) {
		this.personaid = personaid;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.correoelectronico = correoelectronico;
		this.telefono = telefono;
	}

	public Integer getPersonaid() {
		return this.personaid;
	}

	public void setPersonaid(Integer personaid) {
		this.personaid = personaid;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreoelectronico() {
		return this.correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}