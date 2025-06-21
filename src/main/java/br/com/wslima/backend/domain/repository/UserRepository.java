package br.com.wslima.backend.domain.repository;

import br.com.wslima.backend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
