package com.codeup.fadspringer.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="fads")
public class Fad {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String title;

    @Type(type="text")
    private String description;

    @Column(length=2083)
    private String img_url = "http://via.placeholder.com/300x300";

    @Column(nullable=false, columnDefinition = "boolean default false")
    private Boolean passe;

    @CreationTimestamp
    private Timestamp created_at;

    @UpdateTimestamp
    private Timestamp updated_at;

    @ManyToOne
    @JoinColumn(name="user_id", foreignKey=@ForeignKey(name = "Fk_user"))
    private User user;

    public Fad() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public Boolean getPasse() {
        return passe;
    }

    public void setPasse(Boolean passe) {
        this.passe = passe;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
