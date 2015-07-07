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
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1224690490;

	private Integer usuarioid;
	private Integer personaid;
	private String  nombreusuario;
	private String  contrasenia;
	private Integer rol;

	public Usuario() {}

	public Usuario(Usuario value) {
		this.usuarioid = value.usuarioid;
		this.personaid = value.personaid;
		this.nombreusuario = value.nombreusuario;
		this.contrasenia = value.contrasenia;
		this.rol = value.rol;
	}

	public Usuario(
		Integer usuarioid,
		Integer personaid,
		String  nombreusuario,
		String  contrasenia,
		Integer rol
	) {
		this.usuarioid = usuarioid;
		this.personaid = personaid;
		this.nombreusuario = nombreusuario;
		this.contrasenia = contrasenia;
		this.rol = rol;
	}

	public Integer getUsuarioid() {
		return this.usuarioid;
	}

	public void setUsuarioid(Integer usuarioid) {
		this.usuarioid = usuarioid;
	}

	public Integer getPersonaid() {
		return this.personaid;
	}

	public void setPersonaid(Integer personaid) {
		this.personaid = personaid;
	}

	public String getNombreusuario() {
		return this.nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Integer getRol() {
		return this.rol;
	}

	public void setRol(Integer rol) {
		this.rol = rol;
	}
}
