package jp.co.everrisesample.minimum01.entity;

import java.io.Serializable;
import java.sql.Date;

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
public class User  extends AbstractEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /** PK */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    /** user name for display */
    @Column(length = 100, nullable = false)
    public String name;
    /** login id for login */
    @Column(length = 255, nullable = false)
    public String loginId;
    /**
     * password for login
     * It's scramble value not raw
     */
    @Column(length = 255, nullable = false)
    public String password;
    
    @Column(precision = 10, nullable = true)
    public Long departmentId;

    @Column
    public Date birthday;

    @Column(length = 1000, nullable = true)
    public String memo;

}
