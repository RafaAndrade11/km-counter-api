package me.kmcounter.domain.model;

import jakarta.persistence.*;
import me.kmcounter.dtos.client.ClientDataCreate;

@Entity(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 8, nullable = false)
    private String zipCode;

    public Client(ClientDataCreate data) {
        this.name = data.name();
        this.zipCode = data.zipCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
