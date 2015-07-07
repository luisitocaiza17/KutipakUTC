/**
 * This class is generated by jOOQ
 */
package persistencia;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import persistencia.tables.Estructura;
import persistencia.tables.Estructurapalabras;
import persistencia.tables.Idiomas;
import persistencia.tables.Palabras;
import persistencia.tables.Personas;
import persistencia.tables.Tiempos;
import persistencia.tables.Tipospalabras;
import persistencia.tables.Usuario;


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
public class Kutipak extends SchemaImpl {

	private static final long serialVersionUID = -1891693000;

	/**
	 * The reference instance of <code>kutipak</code>
	 */
	public static final Kutipak KUTIPAK = new Kutipak();

	/**
	 * No further instances allowed
	 */
	private Kutipak() {
		super("kutipak");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Estructura.ESTRUCTURA,
			Estructurapalabras.ESTRUCTURAPALABRAS,
			Idiomas.IDIOMAS,
			Palabras.PALABRAS,
			Personas.PERSONAS,
			Tiempos.TIEMPOS,
			Tipospalabras.TIPOSPALABRAS,
			Usuario.USUARIO);
	}
}
