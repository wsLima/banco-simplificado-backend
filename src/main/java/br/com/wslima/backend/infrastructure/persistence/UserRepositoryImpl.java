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
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public Optional<User> findByEmailOrCpfCnpj(String email, String cpfCnpj) {
        String query = "SELECT u FROM User u WHERE u.email = :email OR u.cpfCnpj = :cpfCnpj";
        return entityManager.createQuery(query, User.class)
                .setParameter("email", email)
                .setParameter("cpfCnpj", cpfCnpj)
                .getResultStream()
                .findFirst();
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }
    }
}
