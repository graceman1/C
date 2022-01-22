package course.codejava.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRegistrationRepository extends CrudRepository<CourseRegistration, Long> {

  /*  @Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
      + " OR c.email LIKE '%' || :keyword || '%'"
      + " OR c.address LIKE '%' || :keyword || '%'")
  public List<Customer> search(@Param("keyword") String keyword);
   */

  @Query(value = "SELECT cr FROM CourseRegistration cr WHERE cr.studentId = :studentId ")
  public List<CourseRegistration> getMyCourseList(@Param("studentId") Long studentId);

}
