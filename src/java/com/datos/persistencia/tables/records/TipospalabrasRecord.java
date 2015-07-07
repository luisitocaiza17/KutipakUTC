/**
 * This class is generated by jOOQ
 */
package persistencia.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import persistencia.tables.Tipospalabras;


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
public class TipospalabrasRecord extends UpdatableRecordImpl<TipospalabrasRecord> implements Record2<Integer, String> {

	private static final long serialVersionUID = 861262843;

	/**
	 * Setter for <code>kutipak.tipospalabras.TIPOID</code>.
	 */
	public void setTipoid(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>kutipak.tipospalabras.TIPOID</code>.
	 */
	public Integer getTipoid() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>kutipak.tipospalabras.NOMBRETIPO</code>.
	 */
	public void setNombretipo(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>kutipak.tipospalabras.NOMBRETIPO</code>.
	 */
	public String getNombretipo() {
		return (String) getValue(1);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, String> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, String> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Tipospalabras.TIPOSPALABRAS.TIPOID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Tipospalabras.TIPOSPALABRAS.NOMBRETIPO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getTipoid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getNombretipo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipospalabrasRecord value1(Integer value) {
		setTipoid(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipospalabrasRecord value2(String value) {
		setNombretipo(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TipospalabrasRecord values(Integer value1, String value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TipospalabrasRecord
	 */
	public TipospalabrasRecord() {
		super(Tipospalabras.TIPOSPALABRAS);
	}

	/**
	 * Create a detached, initialised TipospalabrasRecord
	 */
	public TipospalabrasRecord(Integer tipoid, String nombretipo) {
		super(Tipospalabras.TIPOSPALABRAS);

		setValue(0, tipoid);
		setValue(1, nombretipo);
	}
}
