package course.codejava.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
  @Autowired UserRepository repo;

  public void save(User user) {
    repo.save(user);
  }

  public List<User> listAll() {
    return (List<User>) repo.findAll();
  }

  public User findById(Long id) {
    return repo.findById(id).get();
  }

  public User findByUsername(String username) {
    return repo.findByUsername(username);
  }

  public void delete(Long id) {
    repo.deleteById(id);
  }

  public List<User> searchUser(String keyword) {
    return repo.searchUser(keyword);
  }
}
