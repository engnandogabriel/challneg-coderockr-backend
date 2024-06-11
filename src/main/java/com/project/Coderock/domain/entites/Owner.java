package com.project.Coderock.domain.entites;

import java.util.UUID;

public class Owner {
    private String owner_id;
    private String name;

    public Owner() {
    }

    private Owner(String owner_id, String name) {
        this.owner_id = owner_id;
        this.name = name;
    }

    public static Owner create(String name) {
        UUID id = UUID.randomUUID();
        return new Owner(id.toString(), name);
    }

    public static Owner restore(String id, String name) {
        return new Owner(id, name);
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
}
