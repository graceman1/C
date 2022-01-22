package course.codejava.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegistrationController {


  @Autowired
  private UserService userService;

  @Autowired
  private CourseRegistrationService courseRegistrationService;


  @Autowired
  private CourseService courseService;

  @RequestMapping("/")
  public ModelAndView home(HttpServletRequest request,Model model) {

    ModelAndView mav = new ModelAndView("login");
    return mav;
  }

  @RequestMapping(value = "/submitLogin",method = RequestMethod.POST)
  public String submit(HttpServletRequest request, Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
    if ((loginBean != null) && ((loginBean.getUserName() != null) & (loginBean.getPassword() != null))) {
      if ((loginBean.getUserName().equals("grace")|| loginBean.getUserName().equals("admin")) && loginBean.getPassword().equals("user")) {
        model.addAttribute("msg", loginBean.getUserName());

        User user = userService.findByUsername(loginBean.getUserName());

        HttpSession session = request.getSession();
        session.setAttribute("loginUser", user);

        if (user.getRole().equalsIgnoreCase("student")) {

          // student log in - manage account and register course
          //

          List<CourseRegistration> myCourseList = courseRegistrationService.getMyCouseList(user.getId());
          List<Course> courseList = courseService.listAll();

          if((myCourseList != null) && (myCourseList.size() >0))
          {

            for (int count = 0; count < myCourseList.size(); count++)
            {

              for (int index = 0; index < courseList.size(); index++)
              {

                if ( (myCourseList.get(count)).getCourseId().equals(((courseList.get(index)).getId()))) {

                  (myCourseList.get(count)).setCourseCode((courseList.get(index)).courseCode);
                  (myCourseList.get(count)).setCourseName((courseList.get(index)).courseName);
                  (myCourseList.get(count)).setCourseCredit((courseList.get(index)).courseCredit);

                  break;
                }
              }
            }
          }

          model.addAttribute("myCourseList", myCourseList);
          model.addAttribute("accountId", user.getId().toString());

          return "student";
        }

        if (loginBean.getUserName().equals("admin")) {

          // admin log in - manage users
          //
          List<User> userList = userService.listAll();


          model.addAttribute("userList", userList);

          return "admin_userList";
        }

        return "index";
      } else {
        model.addAttribute("error", "Invalid Details");
        return "login";
      }
    } else {
      model.addAttribute("error", "Please enter Details");
      return "login";
    }
  }



  @RequestMapping("/newCourse")
  public String newCourseForm(HttpServletRequest request,Map<String, Object> model) {
    Course course = new Course();
    model.put("course", course);
    return "new_course";
  }

  @RequestMapping("/backtoAdminPage")
  public String backToAdminPage(HttpServletRequest request,Model model) {

    // admin log in - manage users
    //

    List<User> listUsers = userService.listAll();
    List<Course> listCourses= courseService.listAll();

    model.addAttribute("listUsers", listUsers);
    model.addAttribute("listCourses", listCourses);

    return "admin";
  }

  @RequestMapping("/newUser")
  public String newUserForm(Map<String, Object> model) {
    User auser = new User();
    model.put("auser", auser);
    return "new_user";
  }



  @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
  public String saveUser(HttpServletRequest request,Model model,@ModelAttribute("user") User user) {

    userService.save(user);

    User loginUser = (User)request.getSession().getAttribute("loginUser");

    if (user.getRole().equalsIgnoreCase("student") && (loginUser.getUsername().equalsIgnoreCase(user.getUsername())))
    {
      // student login into his account
      //
      List<CourseRegistration> myCourseList = courseRegistrationService.getMyCouseList(2L);
      List<Course> courseList = courseService.listAll();

      if((myCourseList != null) && (myCourseList.size() >0))
      {

        for (int count = 0; count < myCourseList.size(); count++)
        {

          for (int index = 0; index < courseList.size(); index++)
          {

            if ( (myCourseList.get(count)).getCourseId().equals(((courseList.get(index)).getId()))) {

              (myCourseList.get(count)).setCourseCode((courseList.get(index)).courseCode);
              (myCourseList.get(count)).setCourseName((courseList.get(index)).courseName);
              (myCourseList.get(count)).setCourseCredit((courseList.get(index)).courseCredit);

              break;
            }
          }
        }
      }
      model.addAttribute("myCourseList", myCourseList);
      model.addAttribute("accountId", loginUser.getId().toString());

      return "student";
    }

    // admin login
    //
    List<User> userList = userService.listAll();

    model.addAttribute("userList", userList);

    return "admin_userList";

  }

  @RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
  public String saveNewCourse(HttpServletRequest request,Model model,@ModelAttribute("course") Course course) {
    courseService.save(course);

    List<Course> courseList= courseService.listAll();

    model.addAttribute("courseList", courseList);

    return "admin_courseList";
  }


  @RequestMapping("/editUser")
  public ModelAndView editUser(HttpServletRequest request,@RequestParam long id) {
    ModelAndView mav = new ModelAndView("edit_user");
    User user = userService.findById(id);
    mav.addObject("user", user);

    mav.addObject("accountId", user.getId().toString());

    return mav;
  }

  @RequestMapping("/updateMyAccount")
  public ModelAndView updateMyAccount(HttpServletRequest request,@RequestParam long id) {
    ModelAndView mav = new ModelAndView("updateMyAccount");
    User user = userService.findById(id);
    mav.addObject("user", user);

    mav.addObject("accountId", user.getId().toString());

    return mav;
  }

  @RequestMapping("/editCourse")
  public ModelAndView editCourse(HttpServletRequest request,@RequestParam long id) {
    ModelAndView mav = new ModelAndView("edit_course");
    Course course = courseService.findById(id);
    mav.addObject("course", course);

    return mav;
  }

  @RequestMapping("/editRegistration")
  public ModelAndView editRegistration(HttpServletRequest request,@RequestParam long id) {
    ModelAndView mav = new ModelAndView("editRegistration");
    CourseRegistration courseRegistration= courseRegistrationService.findById(id);
    mav.addObject("courseRegistration", courseRegistration);

    return mav;
  }

  @RequestMapping("/registerCourse")
  public String registerCourse(HttpServletRequest request,Model model) {

    List<Course> courseList = courseService.listAll();
    System.out.println("***couse list" + courseList.size());
    System.out.println("***couse list" + courseList.get(0).id.toString());
    System.out.println("***couse list" + courseList.get(0).courseName);

    model.addAttribute("courseList",courseList);
    return "courseRegistration";
  }

  @RequestMapping("/saveNewRegistration")
  public String saveNewRegistration(HttpServletRequest request,Model model,@RequestParam("courseId") Long courseId) {

    System.out.println("***selected couse:" + String.valueOf(courseId));

    User loginUser = (User)request.getSession().getAttribute("loginUser");

    CourseRegistration  registration = new CourseRegistration();

    registration.setCourseId(courseId);
    registration.setStudentId(loginUser.getId());
    registration.setRegistrationDate(new Date());

    courseRegistrationService.save(registration);

    // student log in - manage account and register course
    //
    List<CourseRegistration> myCourseList = courseRegistrationService.getMyCouseList(loginUser.getId());
    List<Course> courseList = courseService.listAll();

    if((myCourseList != null) && (myCourseList.size() >0))
    {

      for (int count = 0; count < myCourseList.size(); count++)
      {

        for (int index = 0; index < courseList.size(); index++)
        {

          if ( (myCourseList.get(count)).getCourseId().equals(((courseList.get(index)).getId()))) {

            (myCourseList.get(count)).setCourseCode((courseList.get(index)).courseCode);
            (myCourseList.get(count)).setCourseName((courseList.get(index)).courseName);
            (myCourseList.get(count)).setCourseCredit((courseList.get(index)).courseCredit);

            break;
          }
        }
      }
    }

    model.addAttribute("myCourseList", myCourseList);
    model.addAttribute("accountId", loginUser.getId().toString());

    return "student";
  }

  @RequestMapping("/cancelRegistration")
  public String cancelRegistration(HttpServletRequest request,Model model,@RequestParam long id) {

    User loginUser = (User)request.getSession().getAttribute("loginUser");
    courseRegistrationService.delete(id);

    List<CourseRegistration> myCourseList = courseRegistrationService.getMyCouseList(loginUser.getId());
    List<Course> courseList = courseService.listAll();

    if((myCourseList != null) && (myCourseList.size() >0))
    {

      for (int count = 0; count < myCourseList.size(); count++)
      {

        for (int index = 0; index < courseList.size(); index++)
        {

          if ( (myCourseList.get(count)).getCourseId().equals(((courseList.get(index)).getId()))) {

            (myCourseList.get(count)).setCourseCode((courseList.get(index)).courseCode);
            (myCourseList.get(count)).setCourseName((courseList.get(index)).courseName);
            (myCourseList.get(count)).setCourseCredit((courseList.get(index)).courseCredit);

            break;
          }
        }
      }
    }


    model.addAttribute("myCourseList", myCourseList);
    model.addAttribute("accountId", loginUser.getId().toString());
    return "student";
  }

  @RequestMapping("/courseList")
  public ModelAndView listCourses(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("admin_courseList");
    List<Course> courseList= courseService.listAll();
    mav.addObject("courseList", courseList);

    return mav;
  }

  @RequestMapping("/userList")
  public ModelAndView listUsers(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("admin_userList");
    List<User> userList = userService.listAll();
    mav.addObject("userList", userList);

    return mav;
  }


  @RequestMapping("/deleteUser")
  public String deleteUser(HttpServletRequest request,Model model,@RequestParam long id) {
    userService.delete(id);

    List<User> userList = userService.listAll();

    model.addAttribute("userList", userList);

    return "admin_userList";
  }

  @RequestMapping("/deleteCourse")
  public String deleteCourse(HttpServletRequest request,Model model,@RequestParam long id) {
    courseService.delete(id);

    List<Course> courseList= courseService.listAll();

    model.addAttribute("courseList", courseList);

    return "admin_courseList";
  }

  @RequestMapping("/search")
  public ModelAndView search(HttpServletRequest request,@RequestParam String keyword) {
    List<User> result = userService.searchUser(keyword);
    ModelAndView mav = new ModelAndView("search");
    mav.addObject("result", result);

    return mav;
  }

  @RequestMapping("/searchUser")
  public ModelAndView searchUser(HttpServletRequest request,@RequestParam String keyword) {
    List<User> userList = userService.searchUser(keyword);

    ModelAndView mav = new ModelAndView("admin_userList");
    mav.addObject("userList", userList);

    return mav;
  }

}
