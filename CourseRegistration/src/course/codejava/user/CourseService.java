package course.codejava.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {
  @Autowired CourseRepository repo;

  public void save(Course course) {
    repo.save(course);
  }

  public List<Course> listAll() {
    return (List<Course>) repo.findAll();
  }

  public Course findById(Long id) {
    return repo.findById(id).get();
  }

  public void delete(Long id) {
    repo.deleteById(id);
  }


}
