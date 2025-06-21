package br.com.wslima.backend.infrastructure.persistence;

import br.com.wslima.backend.domain.model.User;
import br.com.wslima.backend.domain.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmailOrCpfCnpj(String email, String cpfCnpj) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }
}
