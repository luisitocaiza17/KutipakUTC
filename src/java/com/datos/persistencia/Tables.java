/**
 * This class is generated by jOOQ
 */
package persistencia;


import javax.annotation.Generated;

import persistencia.tables.Estructura;
import persistencia.tables.Estructurapalabras;
import persistencia.tables.Idiomas;
import persistencia.tables.Palabras;
import persistencia.tables.Pantallapalabras;
import persistencia.tables.Personas;
import persistencia.tables.Tiempos;
import persistencia.tables.Tipospalabras;
import persistencia.tables.Usuario;


/**
 * Convenience access to all tables in kutipak
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * The table kutipak.estructura
	 */
	public static final Estructura ESTRUCTURA = persistencia.tables.Estructura.ESTRUCTURA;

	/**
	 * The table kutipak.estructurapalabras
	 */
	public static final Estructurapalabras ESTRUCTURAPALABRAS = persistencia.tables.Estructurapalabras.ESTRUCTURAPALABRAS;

	/**
	 * The table kutipak.idiomas
	 */
	public static final Idiomas IDIOMAS = persistencia.tables.Idiomas.IDIOMAS;

	/**
	 * The table kutipak.palabras
	 */
	public static final Palabras PALABRAS = persistencia.tables.Palabras.PALABRAS;

	/**
	 * VIEW
	 */
	public static final Pantallapalabras PANTALLAPALABRAS = persistencia.tables.Pantallapalabras.PANTALLAPALABRAS;

	/**
	 * The table kutipak.personas
	 */
	public static final Personas PERSONAS = persistencia.tables.Personas.PERSONAS;

	/**
	 * The table kutipak.tiempos
	 */
	public static final Tiempos TIEMPOS = persistencia.tables.Tiempos.TIEMPOS;

	/**
	 * The table kutipak.tipospalabras
	 */
	public static final Tipospalabras TIPOSPALABRAS = persistencia.tables.Tipospalabras.TIPOSPALABRAS;

	/**
	 * The table kutipak.usuario
	 */
	public static final Usuario USUARIO = persistencia.tables.Usuario.USUARIO;
}
