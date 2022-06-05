package com.example.springbootbackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JoinColumn(name = "firmaId")
    private long firmaId;
    @Column(name = "companyName", nullable = false)
    private String companyName;
    @Column(name = "address")
    private String address;
}
