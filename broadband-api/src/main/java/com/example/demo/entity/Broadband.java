package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "broadband")
public class Broadband {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_id")
    private Integer connectionId;

    @Column(name = "provider_name", length = 45)
    private String providerName;

    @ManyToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    private Plan plan;

    // Constructors

    public Broadband() {
    }

    public Broadband(String providerName, Plan plan) {
        this.providerName = providerName;
        this.plan = plan;
    }

    // Getters and Setters

    public Integer getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Integer connectionId) {
        this.connectionId = connectionId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    // toString

    @Override
    public String toString() {
        return "Broadband{" +
                "connectionId=" + connectionId +
                ", providerName='" + providerName + '\'' +
                ", plan=" + plan +
                '}';
    }
}
