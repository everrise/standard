package jp.co.everrisesample.minimum01.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity{
    @Column(nullable = true, unique = false, columnDefinition="datetime")
    public Timestamp deletedAt;
    @Column(nullable = true, unique = false, columnDefinition="datetime")
    public Timestamp updatedAt;
    @Column(nullable = true, unique = false, columnDefinition="datetime")
    public Timestamp createdAt;
    
    public void setParamsForNew(){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.createdAt = now;
        this.updatedAt = now;
    }
    public void setParamsForUpdate(){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        updatedAt = now;
    }
    public void setParamsForDelete(){
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.deletedAt = now;
    }
}