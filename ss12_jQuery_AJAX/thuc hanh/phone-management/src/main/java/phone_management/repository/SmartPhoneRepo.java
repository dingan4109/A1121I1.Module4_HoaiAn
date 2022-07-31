package phone_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phone_management.entity.SmartPhone;
@Repository
public interface SmartPhoneRepo extends JpaRepository<SmartPhone,Long> {
}
