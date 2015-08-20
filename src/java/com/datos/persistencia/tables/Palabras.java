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

import persistencia.Keys;
import persistencia.Kutipak;
import persistencia.tables.records.PalabrasRecord;


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
public class Palabras extends TableImpl<PalabrasRecord> {

	private static final long serialVersionUID = -902871927;

	/**
	 * The reference instance of <code>kutipak.palabras</code>
	 */
	public static final Palabras PALABRAS = new Palabras();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<PalabrasRecord> getRecordType() {
		return PalabrasRecord.class;
	}

	/**
	 * The column <code>kutipak.palabras.PALABRAID</code>.
	 */
	public final TableField<PalabrasRecord, Integer> PALABRAID = createField("PALABRAID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>kutipak.palabras.IDIOMAID</code>.
	 */
	public final TableField<PalabrasRecord, Integer> IDIOMAID = createField("IDIOMAID", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>kutipak.palabras.TIPOID</code>.
	 */
	public final TableField<PalabrasRecord, Integer> TIPOID = createField("TIPOID", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>kutipak.palabras.PAL_PALABRAID</code>.
	 */
	public final TableField<PalabrasRecord, Integer> PAL_PALABRAID = createField("PAL_PALABRAID", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>kutipak.palabras.TIEMPOSID</code>.
	 */
	public final TableField<PalabrasRecord, Integer> TIEMPOSID = createField("TIEMPOSID", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>kutipak.palabras.NOMBREPALABRA</code>.
	 */
	public final TableField<PalabrasRecord, String> NOMBREPALABRA = createField("NOMBREPALABRA", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

	/**
	 * The column <code>kutipak.palabras.SINONIMO</code>.
	 */
	public final TableField<PalabrasRecord, String> SINONIMO = createField("SINONIMO", org.jooq.impl.SQLDataType.VARCHAR.length(40), this, "");

	/**
	 * Create a <code>kutipak.palabras</code> table reference
	 */
	public Palabras() {
		this("palabras", null);
	}

	/**
	 * Create an aliased <code>kutipak.palabras</code> table reference
	 */
	public Palabras(String alias) {
		this(alias, PALABRAS);
	}

	private Palabras(String alias, Table<PalabrasRecord> aliased) {
		this(alias, aliased, null);
	}

	private Palabras(String alias, Table<PalabrasRecord> aliased, Field<?>[] parameters) {
		super(alias, Kutipak.KUTIPAK, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<PalabrasRecord, Integer> getIdentity() {
		return Keys.IDENTITY_PALABRAS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<PalabrasRecord> getPrimaryKey() {
		return Keys.KEY_PALABRAS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<PalabrasRecord>> getKeys() {
		return Arrays.<UniqueKey<PalabrasRecord>>asList(Keys.KEY_PALABRAS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<PalabrasRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<PalabrasRecord, ?>>asList(Keys.FK_IDIOMASPALABRAS, Keys.FK_TIPOPALABRAS, Keys.FK_KEOEK, Keys.FK_TIEMPOSPALABRAS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Palabras as(String alias) {
		return new Palabras(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Palabras rename(String name) {
		return new Palabras(name, null);
	}
}
