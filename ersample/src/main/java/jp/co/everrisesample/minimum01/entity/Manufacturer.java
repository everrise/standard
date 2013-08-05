package jp.co.everrisesample.minimum01.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * ユーザー情報を管理するEntity
 *
 */
@Entity
public class Manufacturer  extends AbstractEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long manufactureId;

    @Column(length = 200, nullable = false)
    public String name;

    @OneToMany(mappedBy="manufacturer")
    public List<Product> product;
}
