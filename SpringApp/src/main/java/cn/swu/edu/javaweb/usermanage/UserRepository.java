package cn.swu.edu.javaweb.usermanage;

import cn.swu.edu.javaweb.usermanage.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findOneByUsername(String username);
}
