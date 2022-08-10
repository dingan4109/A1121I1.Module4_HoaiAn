package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    User findByUsernameContaining(String username);
}
