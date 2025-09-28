package io.github.jason13official.quickstart_demo;

import io.github.jason13official.quickstart_demo.impl.Car;
import io.github.jason13official.quickstart_demo.impl.Person;
import io.github.jason13official.quickstart_demo.impl.Status;
import io.github.jason13official.quickstart_demo.impl.Student;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} is for annotating endpoints/port listeners that should be available with
 * web requests (TCP/UDP?)
 */
@SpringBootApplication
@RestController
public class QuickstartDemoApplication {

  public static Student[] studentsForDemo = new Student[]{
      new Student(new Person("Jason", 25), false, new Car("Ford", "Ranger")),
      new Student(new Person("David", 27), true, new Car("Ford", "Maverick")),
      new Student(new Person("Barry", 29), true, new Car("Ford", "Bronco"))
  };

  // so we don't create a new record every request
  private static final Person JASON = new Person("Jason", 25);

  private static Status PLAYER_STATUS = Status.RESPAWNING;

  public static void main(String[] args) {

    // runs the specified source using default settings; DI of default values to create new object
    SpringApplication.run(QuickstartDemoApplication.class, args);
  }

  private static String asH1(String s) {
    return "<h1>" + s + "</h1>";
  }

  /**
   * Quite a lot to unpack here... <br /> {@link GetMapping} maps requests to `/hello` (i.e.
   * `http://localhost:8080/hello`) <br /> {@link RequestParam} expects a value, but provides a safe
   * default if no value was passed
   */
  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  /**
   * Returning a hard-coded String representation of a Person object
   */
  @GetMapping("/person/manualSerialization")
  public String personManual() {
    return asH1(JASON.toPrettyString());
  }

  /**
   * Returning a new Person object created from passed values (without {@link RequestParam})
   */
  @GetMapping("/person")
  public Person person(String name, Integer age) {
    return new Person(name, age);
  }

  /** Returns a new Student object created from passed values (some of which are primitives) */
  @GetMapping("/student")
  public Student student(String name, int age, boolean undergraduate, String carMake, String carModel) {
    return new Student(new Person(name, age), undergraduate, new Car(carMake, carModel));
  }

  /** Returns an Array representation of studentsForDemo */
  @GetMapping("/student/array")
  public Student[] studentArray() {
    return studentsForDemo;
  }

  /** Returns a List representation of studentsForDemo */
  @GetMapping("/student/list")
  public List<Student> studentList() {
    return List.of(studentsForDemo);
  }

  /** Returns a Set representation of studentsForDemo */
  @GetMapping("/student/set")
  public Set<Student> studentSet() {
    return Set.of(studentsForDemo);
  }

  @GetMapping("status/simple")
  public Status getSimpleStatus() {
    return PLAYER_STATUS;
  }

  @PostMapping("/status/simple")
  public Status postSimpleState(@RequestParam(value = "index", defaultValue = "") Integer index) {

    // cycle if no index provided or invalid, else set to index
    if (index == null || (index < 0) || (index > Status.values().length - 1)) {
      PLAYER_STATUS = Status.values()[(PLAYER_STATUS.ordinal() + 1) % Status.values().length];
    } else {
      PLAYER_STATUS = Status.values()[index];
    }

    return PLAYER_STATUS;
  }
}
