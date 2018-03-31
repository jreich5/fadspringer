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

    private Boolean passe;

    @CreationTimestamp
    private Timestamp created_at;

    @UpdateTimestamp
    private Timestamp updated_at;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
