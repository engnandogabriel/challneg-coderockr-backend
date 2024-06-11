package com.project.Coderock.infra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "owners")
public class OwnerModel {
    @Id
    @Column(name = "owner_id")
    private String owner_id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public OwnerModel() {
    }

    public OwnerModel(String owner_id, String name, String email) {
        this.owner_id = owner_id;
        this.name = name;
        this.email = email;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
