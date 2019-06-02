package cn.swu.edu.javaweb.user;


import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
