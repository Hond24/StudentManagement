package raisetech.StudentManagement.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    //検索処理を実行する
    List<Student> studentList30s = new ArrayList<>();

     //絞り込み処理を実行する、３０代の人のみを取得する
    for (Student student : repository.search()) {
      LocalDate birthday = student.getBirthday();
      int age = LocalDate.now().getYear() - birthday.getYear();

      if (age >= 30 && age < 40) {
        studentList30s.add(student);
      }
    }
    //抽出したリストをコントローラーに返す
    return studentList30s;
  }

  public List<StudentsCourses> searchStudentsCourseList() {
    //絞り込み検索でjavaコースのみを取得する　
    List<StudentsCourses> javaCourseList = new ArrayList<>();

    for (StudentsCourses studentsCourses : repository.searchStudentsCourses()) {
      if (studentsCourses.getCourseName().equals("Java")) {
        javaCourseList.add(studentsCourses);
      }
    }
    //抽出したリストをコントローラーに返す
    return javaCourseList;
  }
}
