package br.com.wslima.backend.domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String cpfCnpj;
    private String email;
    private String password;
    private String type;
    private BigDecimal balance;
}
