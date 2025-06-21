package br.com.wslima.backend.domain.model;


import br.com.wslima.backend.commons.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String cpfCnpj;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType type;
    private BigDecimal balance;
}
