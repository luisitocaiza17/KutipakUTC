/**
 * This class is generated by jOOQ
 */
package persistencia;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import persistencia.tables.Estructura;
import persistencia.tables.Estructurapalabras;
import persistencia.tables.Idiomas;
import persistencia.tables.Palabras;
import persistencia.tables.Personas;
import persistencia.tables.Tiempos;
import persistencia.tables.Tipospalabras;
import persistencia.tables.Usuario;
import persistencia.tables.records.EstructuraRecord;
import persistencia.tables.records.EstructurapalabrasRecord;
import persistencia.tables.records.IdiomasRecord;
import persistencia.tables.records.PalabrasRecord;
import persistencia.tables.records.PersonasRecord;
import persistencia.tables.records.TiemposRecord;
import persistencia.tables.records.TipospalabrasRecord;
import persistencia.tables.records.UsuarioRecord;


/**
 * A class modelling foreign key relationships between tables of the <code>kutipak</code> 
 * schema
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final Identity<EstructuraRecord, Integer> IDENTITY_ESTRUCTURA = Identities0.IDENTITY_ESTRUCTURA;
	public static final Identity<IdiomasRecord, Integer> IDENTITY_IDIOMAS = Identities0.IDENTITY_IDIOMAS;
	public static final Identity<PalabrasRecord, Integer> IDENTITY_PALABRAS = Identities0.IDENTITY_PALABRAS;
	public static final Identity<PersonasRecord, Integer> IDENTITY_PERSONAS = Identities0.IDENTITY_PERSONAS;
	public static final Identity<TiemposRecord, Integer> IDENTITY_TIEMPOS = Identities0.IDENTITY_TIEMPOS;
	public static final Identity<TipospalabrasRecord, Integer> IDENTITY_TIPOSPALABRAS = Identities0.IDENTITY_TIPOSPALABRAS;
	public static final Identity<UsuarioRecord, Integer> IDENTITY_USUARIO = Identities0.IDENTITY_USUARIO;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<EstructuraRecord> KEY_ESTRUCTURA_PRIMARY = UniqueKeys0.KEY_ESTRUCTURA_PRIMARY;
	public static final UniqueKey<EstructurapalabrasRecord> KEY_ESTRUCTURAPALABRAS_PRIMARY = UniqueKeys0.KEY_ESTRUCTURAPALABRAS_PRIMARY;
	public static final UniqueKey<IdiomasRecord> KEY_IDIOMAS_PRIMARY = UniqueKeys0.KEY_IDIOMAS_PRIMARY;
	public static final UniqueKey<PalabrasRecord> KEY_PALABRAS_PRIMARY = UniqueKeys0.KEY_PALABRAS_PRIMARY;
	public static final UniqueKey<PersonasRecord> KEY_PERSONAS_PRIMARY = UniqueKeys0.KEY_PERSONAS_PRIMARY;
	public static final UniqueKey<TiemposRecord> KEY_TIEMPOS_PRIMARY = UniqueKeys0.KEY_TIEMPOS_PRIMARY;
	public static final UniqueKey<TipospalabrasRecord> KEY_TIPOSPALABRAS_PRIMARY = UniqueKeys0.KEY_TIPOSPALABRAS_PRIMARY;
	public static final UniqueKey<UsuarioRecord> KEY_USUARIO_PRIMARY = UniqueKeys0.KEY_USUARIO_PRIMARY;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final ForeignKey<EstructuraRecord, IdiomasRecord> FK_IDIOMA_ESTRUCTURA = ForeignKeys0.FK_IDIOMA_ESTRUCTURA;
	public static final ForeignKey<EstructurapalabrasRecord, TipospalabrasRecord> FK_ESTRUCTURASTIPOS = ForeignKeys0.FK_ESTRUCTURASTIPOS;
	public static final ForeignKey<EstructurapalabrasRecord, EstructuraRecord> FK_PALABRASESTRUCTURAS = ForeignKeys0.FK_PALABRASESTRUCTURAS;
	public static final ForeignKey<PalabrasRecord, IdiomasRecord> FK_IDIOMASPALABRAS = ForeignKeys0.FK_IDIOMASPALABRAS;
	public static final ForeignKey<PalabrasRecord, TipospalabrasRecord> FK_TIPOPALABRAS = ForeignKeys0.FK_TIPOPALABRAS;
	public static final ForeignKey<PalabrasRecord, PalabrasRecord> FK_KEOEK = ForeignKeys0.FK_KEOEK;
	public static final ForeignKey<PalabrasRecord, TiemposRecord> FK_TIEMPOSPALABRAS = ForeignKeys0.FK_TIEMPOSPALABRAS;
	public static final ForeignKey<UsuarioRecord, PersonasRecord> FK_PERSONAUSUARIO = ForeignKeys0.FK_PERSONAUSUARIO;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends AbstractKeys {
		public static Identity<EstructuraRecord, Integer> IDENTITY_ESTRUCTURA = createIdentity(Estructura.ESTRUCTURA, Estructura.ESTRUCTURA.ESTRUCTURAID);
		public static Identity<IdiomasRecord, Integer> IDENTITY_IDIOMAS = createIdentity(Idiomas.IDIOMAS, Idiomas.IDIOMAS.IDIOMAID);
		public static Identity<PalabrasRecord, Integer> IDENTITY_PALABRAS = createIdentity(Palabras.PALABRAS, Palabras.PALABRAS.PALABRAID);
		public static Identity<PersonasRecord, Integer> IDENTITY_PERSONAS = createIdentity(Personas.PERSONAS, Personas.PERSONAS.PERSONAID);
		public static Identity<TiemposRecord, Integer> IDENTITY_TIEMPOS = createIdentity(Tiempos.TIEMPOS, Tiempos.TIEMPOS.TIEMPOSID);
		public static Identity<TipospalabrasRecord, Integer> IDENTITY_TIPOSPALABRAS = createIdentity(Tipospalabras.TIPOSPALABRAS, Tipospalabras.TIPOSPALABRAS.TIPOID);
		public static Identity<UsuarioRecord, Integer> IDENTITY_USUARIO = createIdentity(Usuario.USUARIO, Usuario.USUARIO.USUARIOID);
	}

	private static class UniqueKeys0 extends AbstractKeys {
		public static final UniqueKey<EstructuraRecord> KEY_ESTRUCTURA_PRIMARY = createUniqueKey(Estructura.ESTRUCTURA, Estructura.ESTRUCTURA.ESTRUCTURAID);
		public static final UniqueKey<EstructurapalabrasRecord> KEY_ESTRUCTURAPALABRAS_PRIMARY = createUniqueKey(Estructurapalabras.ESTRUCTURAPALABRAS, Estructurapalabras.ESTRUCTURAPALABRAS.TIPOID);
		public static final UniqueKey<IdiomasRecord> KEY_IDIOMAS_PRIMARY = createUniqueKey(Idiomas.IDIOMAS, Idiomas.IDIOMAS.IDIOMAID);
		public static final UniqueKey<PalabrasRecord> KEY_PALABRAS_PRIMARY = createUniqueKey(Palabras.PALABRAS, Palabras.PALABRAS.PALABRAID);
		public static final UniqueKey<PersonasRecord> KEY_PERSONAS_PRIMARY = createUniqueKey(Personas.PERSONAS, Personas.PERSONAS.PERSONAID);
		public static final UniqueKey<TiemposRecord> KEY_TIEMPOS_PRIMARY = createUniqueKey(Tiempos.TIEMPOS, Tiempos.TIEMPOS.TIEMPOSID);
		public static final UniqueKey<TipospalabrasRecord> KEY_TIPOSPALABRAS_PRIMARY = createUniqueKey(Tipospalabras.TIPOSPALABRAS, Tipospalabras.TIPOSPALABRAS.TIPOID);
		public static final UniqueKey<UsuarioRecord> KEY_USUARIO_PRIMARY = createUniqueKey(Usuario.USUARIO, Usuario.USUARIO.USUARIOID);
	}

	private static class ForeignKeys0 extends AbstractKeys {
		public static final ForeignKey<EstructuraRecord, IdiomasRecord> FK_IDIOMA_ESTRUCTURA = createForeignKey(persistencia.Keys.KEY_IDIOMAS_PRIMARY, Estructura.ESTRUCTURA, Estructura.ESTRUCTURA.IDIOMAID);
		public static final ForeignKey<EstructurapalabrasRecord, TipospalabrasRecord> FK_ESTRUCTURASTIPOS = createForeignKey(persistencia.Keys.KEY_TIPOSPALABRAS_PRIMARY, Estructurapalabras.ESTRUCTURAPALABRAS, Estructurapalabras.ESTRUCTURAPALABRAS.TIPOID);
		public static final ForeignKey<EstructurapalabrasRecord, EstructuraRecord> FK_PALABRASESTRUCTURAS = createForeignKey(persistencia.Keys.KEY_ESTRUCTURA_PRIMARY, Estructurapalabras.ESTRUCTURAPALABRAS, Estructurapalabras.ESTRUCTURAPALABRAS.ESTRUCTURAID);
		public static final ForeignKey<PalabrasRecord, IdiomasRecord> FK_IDIOMASPALABRAS = createForeignKey(persistencia.Keys.KEY_IDIOMAS_PRIMARY, Palabras.PALABRAS, Palabras.PALABRAS.IDIOMAID);
		public static final ForeignKey<PalabrasRecord, TipospalabrasRecord> FK_TIPOPALABRAS = createForeignKey(persistencia.Keys.KEY_TIPOSPALABRAS_PRIMARY, Palabras.PALABRAS, Palabras.PALABRAS.TIPOID);
		public static final ForeignKey<PalabrasRecord, PalabrasRecord> FK_KEOEK = createForeignKey(persistencia.Keys.KEY_PALABRAS_PRIMARY, Palabras.PALABRAS, Palabras.PALABRAS.PAL_PALABRAID);
		public static final ForeignKey<PalabrasRecord, TiemposRecord> FK_TIEMPOSPALABRAS = createForeignKey(persistencia.Keys.KEY_TIEMPOS_PRIMARY, Palabras.PALABRAS, Palabras.PALABRAS.TIEMPOSID);
		public static final ForeignKey<UsuarioRecord, PersonasRecord> FK_PERSONAUSUARIO = createForeignKey(persistencia.Keys.KEY_PERSONAS_PRIMARY, Usuario.USUARIO, Usuario.USUARIO.PERSONAID);
	}
}
