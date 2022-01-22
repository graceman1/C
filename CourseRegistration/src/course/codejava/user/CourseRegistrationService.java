package course.codejava.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseRegistrationService {
  @Autowired CourseRegistrationRepository repo;

  public void save(CourseRegistration courseRegistration) {
    repo.save(courseRegistration);
  }

  public List<CourseRegistration> listAll() {
    return (List<CourseRegistration>) repo.findAll();
  }

  public CourseRegistration findById(Long id) {
    return repo.findById(id).get();
  }

  public void delete(Long id) {
    repo.deleteById(id);
  }


  public List<CourseRegistration> getMyCouseList(Long studentId) {
    return repo.getMyCourseList(studentId);
  }

}
