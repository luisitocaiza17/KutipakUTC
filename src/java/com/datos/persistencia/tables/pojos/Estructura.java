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
public class Estructura implements Serializable {

	private static final long serialVersionUID = -283800685;

	private Integer estructuraid;
	private Integer idiomaid;
	private String  nombreestructura;
	private String  formula;

	public Estructura() {}

	public Estructura(Estructura value) {
		this.estructuraid = value.estructuraid;
		this.idiomaid = value.idiomaid;
		this.nombreestructura = value.nombreestructura;
		this.formula = value.formula;
	}

	public Estructura(
		Integer estructuraid,
		Integer idiomaid,
		String  nombreestructura,
		String  formula
	) {
		this.estructuraid = estructuraid;
		this.idiomaid = idiomaid;
		this.nombreestructura = nombreestructura;
		this.formula = formula;
	}

	public Integer getEstructuraid() {
		return this.estructuraid;
	}

	public void setEstructuraid(Integer estructuraid) {
		this.estructuraid = estructuraid;
	}

	public Integer getIdiomaid() {
		return this.idiomaid;
	}

	public void setIdiomaid(Integer idiomaid) {
		this.idiomaid = idiomaid;
	}

	public String getNombreestructura() {
		return this.nombreestructura;
	}

	public void setNombreestructura(String nombreestructura) {
		this.nombreestructura = nombreestructura;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
}