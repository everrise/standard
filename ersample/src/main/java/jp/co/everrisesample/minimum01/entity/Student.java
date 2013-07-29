package jp.co.everrisesample.minimum01.entity;

import java.io.Serializable;

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
public class Student  extends AbstractEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    /** PK */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    /** student name for display */
    @Column(length = 100, nullable = false)
    public String name;

    @Column
    public String address;

    /** email for display */
    @Column(length = 100, nullable = false)
    public String email;
}
