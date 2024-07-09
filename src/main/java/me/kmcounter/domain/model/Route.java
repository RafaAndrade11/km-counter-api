package me.kmcounter.domain.model;

import jakarta.persistence.*;
import me.kmcounter.dtos.route.RouteDataCreate;

@Entity(name = "tb_route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_client_id")
    private Client originClient;
    @ManyToOne
    @JoinColumn(name = "destination_client_id")
    private Client destinationClient;

    private Double distance;

    public Route() {
    }

    public Route(Client originClient, Client destinationClient, double distance) {
        this.originClient = originClient;
        this.destinationClient = destinationClient;
        this.distance = distance;
    }

    public Route(RouteDataCreate data) {
        this.originClient = data.originClient();
        this.destinationClient = data.destinationClient();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getOriginClient() {
        return originClient;
    }

    public void setOriginClient(Client originClient) {
        this.originClient = originClient;
    }

    public Client getDestinationClient() {
        return destinationClient;
    }

    public void setDestinationClient(Client destinationClient) {
        this.destinationClient = destinationClient;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
