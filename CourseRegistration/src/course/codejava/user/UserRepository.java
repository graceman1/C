package course.codejava.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

  @Query(value = "SELECT u FROM User u WHERE u.firstname LIKE '%' || :keyword || '%'"
      + " OR u.lastname LIKE '%' || :keyword || '%'"
      + " OR u.email LIKE '%' || :keyword || '%'")
  public List<User> searchUser(@Param("keyword") String keyword);

  public User findByUsername(String username);
}
