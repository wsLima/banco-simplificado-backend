package br.com.wslima.backend.domain.repository;

import br.com.wslima.backend.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);

    Optional<User> findByEmailOrCpfCnpj(String email, String cpfCnpj);

    User save(User user);
}
