package pl.sda.springtraining.spring.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findAllByEmail(String email); // fixme todo
}
