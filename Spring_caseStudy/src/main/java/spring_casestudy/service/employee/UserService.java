package spring_casestudy.service.employee;

import spring_casestudy.entity.User;
import spring_casestudy.service.GeneralService;

public interface UserService extends GeneralService<User> {
    User findByUsername(String username);
}
