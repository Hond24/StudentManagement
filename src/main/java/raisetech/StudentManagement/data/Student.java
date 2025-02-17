package raisetech.StudentManagement.data;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Student {

  private String id;
  private String name;
  private String kana;
  private String nickname;
  private String email;
  private String prefecture;
  private String city;
  private String tel;
  private LocalDate birthday;
  private String gender;

}
