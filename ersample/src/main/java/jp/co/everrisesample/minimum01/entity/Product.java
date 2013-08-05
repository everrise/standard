package jp.co.everrisesample.minimum01.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * ユーザー情報を管理するEntity
 *
 */
@Entity
public class Product  extends AbstractEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long productId;

    @Column(length = 200, nullable = false)
    public String name;

    @Column(length = 64, nullable = false)
    public Long manufacturerId;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "manufacture_id")
    public Manufacturer manufacturer;


}
