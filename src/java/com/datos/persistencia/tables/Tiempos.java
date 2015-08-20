/**
 * This class is generated by jOOQ
 */
package persistencia.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import persistencia.Keys;
import persistencia.Kutipak;
import persistencia.tables.records.TiemposRecord;


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
public class Tiempos extends TableImpl<TiemposRecord> {

	private static final long serialVersionUID = -1457676343;

	/**
	 * The reference instance of <code>kutipak.tiempos</code>
	 */
	public static final Tiempos TIEMPOS = new Tiempos();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TiemposRecord> getRecordType() {
		return TiemposRecord.class;
	}

	/**
	 * The column <code>kutipak.tiempos.TIEMPOSID</code>.
	 */
	public final TableField<TiemposRecord, Integer> TIEMPOSID = createField("TIEMPOSID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>kutipak.tiempos.NOMBRETIEMPO</code>.
	 */
	public final TableField<TiemposRecord, String> NOMBRETIEMPO = createField("NOMBRETIEMPO", org.jooq.impl.SQLDataType.VARCHAR.length(40), this, "");

	/**
	 * The column <code>kutipak.tiempos.NEMOTECNICOTIEMPO</code>.
	 */
	public final TableField<TiemposRecord, String> NEMOTECNICOTIEMPO = createField("NEMOTECNICOTIEMPO", org.jooq.impl.SQLDataType.VARCHAR.length(5), this, "");

	/**
	 * Create a <code>kutipak.tiempos</code> table reference
	 */
	public Tiempos() {
		this("tiempos", null);
	}

	/**
	 * Create an aliased <code>kutipak.tiempos</code> table reference
	 */
	public Tiempos(String alias) {
		this(alias, TIEMPOS);
	}

	private Tiempos(String alias, Table<TiemposRecord> aliased) {
		this(alias, aliased, null);
	}

	private Tiempos(String alias, Table<TiemposRecord> aliased, Field<?>[] parameters) {
		super(alias, Kutipak.KUTIPAK, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<TiemposRecord, Integer> getIdentity() {
		return Keys.IDENTITY_TIEMPOS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<TiemposRecord> getPrimaryKey() {
		return Keys.KEY_TIEMPOS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<TiemposRecord>> getKeys() {
		return Arrays.<UniqueKey<TiemposRecord>>asList(Keys.KEY_TIEMPOS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tiempos as(String alias) {
		return new Tiempos(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Tiempos rename(String name) {
		return new Tiempos(name, null);
	}
}
