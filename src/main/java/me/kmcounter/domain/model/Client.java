package me.kmcounter.domain.model;

import jakarta.persistence.*;
import me.kmcounter.dtos.client.ClientDataCreate;
import me.kmcounter.dtos.client.ClientDataUpdate;

@Entity(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 8, nullable = false)
    private String zipCode;

    public Client() {
    }
    public Client(ClientDataCreate data) {
        this.name = data.name();
        this.zipCode = data.zipCode();
    }

    public Client(String name, String zipCode) {
        this.name = name;
        this.zipCode = zipCode;
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

    public void updateClientInfo(ClientDataUpdate data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.zipCode() != null) {
            this.zipCode = data.zipCode();
        }
    }
}
