package com.codeup.fadspringer.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false, length=120)
    private String name;

    @Column(nullable=false, length=120, unique=true)
    private String email;

    @Column(nullable=false, length=120)
    private String password;

    @CreationTimestamp
    private Timestamp created_at;

    @UpdateTimestamp
    private Timestamp updated_at;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private List<Fad> fads;

}

