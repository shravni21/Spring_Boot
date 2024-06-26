package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45)
    @NotNull
    @Size(min = 2, max = 45)
    private String name;

    @Column(name = "address", length = 128)
    @Size(max = 128)
    private String address;

    @Column(name = "contact_number", length = 45)
    @Size(max = 45)
    private String contactNumber;

    @ManyToOne
    @JoinColumn(name = "broadband_connection_id")
    private Broadband broadbandConnection;

    // Constructors

    public Customer() {
    }

    public Customer(String name, String address, String contactNumber, Broadband broadbandConnection) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.broadbandConnection = broadbandConnection;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Broadband getBroadbandConnection() {
        return broadbandConnection;
    }

    public void setBroadbandConnection(Broadband broadbandConnection) {
        this.broadbandConnection = broadbandConnection;
    }

    // toString

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", broadbandConnection=" + broadbandConnection +
                '}';
    }
}
