/**
 * This class is generated by jOOQ
 */
package persistencia.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import com.datos.persistencia.Keys;
import persistencia.Kutipak;
import persistencia.tables.records.UsuarioRecord;


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
public class Usuario extends TableImpl<UsuarioRecord> {

	private static final long serialVersionUID = -1343490283;

	/**
	 * The reference instance of <code>kutipak.usuario</code>
	 */
	public static final Usuario USUARIO = new Usuario();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<UsuarioRecord> getRecordType() {
		return UsuarioRecord.class;
	}

	/**
	 * The column <code>kutipak.usuario.USUARIOID</code>.
	 */
	public final TableField<UsuarioRecord, Integer> USUARIOID = createField("USUARIOID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>kutipak.usuario.PERSONAID</code>.
	 */
	public final TableField<UsuarioRecord, Integer> PERSONAID = createField("PERSONAID", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>kutipak.usuario.NOMBREUSUARIO</code>.
	 */
	public final TableField<UsuarioRecord, String> NOMBREUSUARIO = createField("NOMBREUSUARIO", org.jooq.impl.SQLDataType.VARCHAR.length(40), this, "");

	/**
	 * The column <code>kutipak.usuario.CONTRASENIA</code>.
	 */
	public final TableField<UsuarioRecord, String> CONTRASENIA = createField("CONTRASENIA", org.jooq.impl.SQLDataType.VARCHAR.length(40), this, "");

	/**
	 * The column <code>kutipak.usuario.ROL</code>.
	 */
	public final TableField<UsuarioRecord, Integer> ROL = createField("ROL", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>kutipak.usuario</code> table reference
	 */
	public Usuario() {
		this("usuario", null);
	}

	/**
	 * Create an aliased <code>kutipak.usuario</code> table reference
	 */
	public Usuario(String alias) {
		this(alias, USUARIO);
	}

	private Usuario(String alias, Table<UsuarioRecord> aliased) {
		this(alias, aliased, null);
	}

	private Usuario(String alias, Table<UsuarioRecord> aliased, Field<?>[] parameters) {
		super(alias, Kutipak.KUTIPAK, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<UsuarioRecord, Integer> getIdentity() {
		return Keys.IDENTITY_USUARIO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<UsuarioRecord> getPrimaryKey() {
		return Keys.KEY_USUARIO_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<UsuarioRecord>> getKeys() {
		return Arrays.<UniqueKey<UsuarioRecord>>asList(Keys.KEY_USUARIO_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<UsuarioRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<UsuarioRecord, ?>>asList(Keys.FK_PERSONAUSUARIO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Usuario as(String alias) {
		return new Usuario(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Usuario rename(String name) {
		return new Usuario(name, null);
	}
}
