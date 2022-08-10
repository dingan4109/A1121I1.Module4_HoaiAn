package spring_casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_casestudy.entity.UserRole;

import java.util.List;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,Integer> {
    @Query("SELECT ur.role.roleName FROM UserRole ur WHERE ur.user.username = :username")
    List<String> findAllRoleByUsername(@Param("username") String username);
}
