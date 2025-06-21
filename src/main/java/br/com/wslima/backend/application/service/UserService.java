package br.com.wslima.backend.application.service;

import br.com.wslima.backend.domain.model.User;
import br.com.wslima.backend.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        userRepository.findByEmailOrCpfCnpj(user.getEmail(), user.getCpfCnpj())
                .ifPresent(existing -> {
                    throw new RuntimeException("Email ou CPF/CNPJ já cadastrado");
                });

        user.setPassword(user.getPassword());
        user.setBalance(user.getBalance() != null ? user.getBalance() : BigDecimal.ZERO);

        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
