package com.project.Coderock.domain.entites;

import com.project.Coderock.domain.value_objects.Email;

import java.util.UUID;

public class Owner {
    private String owner_id;
    private String name;
    private Email email;

    public Owner() {
    }

    private Owner(String owner_id, String name, Email email) {
        this.owner_id = owner_id;
        this.name = name;
        this.email = email;
    }

    public static Owner create(String name, String email) throws Exception{
        UUID id = UUID.randomUUID();
        return new Owner(id.toString(), name, Email.create(email));
    }

    public static Owner restore(String id, String name,String email) {
        return new Owner(id, name, Email.restore(email));
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
        return email.getEmail();
    }
}
