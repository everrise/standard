package jp.co.everrisesample.minimum01.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ユーザー情報を管理するEntity
 *
 */
@Entity
@Generated(value = { "S2JDBC-Gen 2.4.45", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl" }, date = "Apr 17, 2013 8:52:00 AM")
public class Chart extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/** PK */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(precision = 10, nullable = false, unique = true)
	public Integer id;
	/** user name for display */
	@Column(length = 100, nullable = false, unique = false)
	public String chart;

	@Column(precision = 10, nullable = false, unique = false)
	public Integer chartId;

	@Column(length = 1000, nullable = true, unique = false)
	public String chartCountry;

	@Column(precision = 10, nullable = true, unique = false)
	public Integer chartQuantity;

	/**
	 * override toString method
	 * return string
	 */
	@Override
	public String toString() {
		return id + "," + chartCountry + "," + chartId + "," + chartQuantity + "," + 2 + "," + 5;
	}
}
