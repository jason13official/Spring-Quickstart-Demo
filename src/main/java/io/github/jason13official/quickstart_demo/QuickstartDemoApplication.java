package io.github.jason13official.quickstart_demo;

import io.github.jason13official.quickstart_demo.impl.Car;
import io.github.jason13official.quickstart_demo.impl.Person;
import io.github.jason13official.quickstart_demo.impl.Status;
import io.github.jason13official.quickstart_demo.impl.Student;
import io.github.jason13official.quickstart_demo.impl.data.Comment;
import io.github.jason13official.quickstart_demo.impl.data.User;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  /**
   * Used for <a href="https://github.com/jason13official/Spring-Quickstart-Demo/issues/8">Issue #8: Intro to Deserialization</a> and {@code USER_ABSTRACT} field
   * <br />
   * This is just the initially assigned list, it may be dereferenced/unused once a postUser request is fulfilled.
   */
  private static LinkedList<Comment> COMMENTS = new LinkedList<>();

  static {
    COMMENTS.add(new Comment(UUID.randomUUID(), "Comments on comments"));
    COMMENTS.add(new Comment(UUID.randomUUID(), "Just another comment, yabba dabba doooooo"));
    COMMENTS.add(new Comment(UUID.randomUUID(), "Yet another comment, yabba dabba doooooo"));
    COMMENTS.add(new Comment(UUID.randomUUID(), "Some other comment, yabba dabba doooooo"));
  }

  /**
   * Used for <a href="https://github.com/jason13official/Spring-Quickstart-Demo/issues/8">Issue #8: Intro to Deserialization</a> and {@code #DESERIALIZATION} section
   */
  private static User USER_ABSTRACT = new User(UUID.randomUUID(), "Jason13", System.currentTimeMillis(), false, COMMENTS);

  private static Status PLAYER_STATUS = Status.RESPAWNING;

  public static void main(String[] args) {

    // runs the specified source using default settings; DI of default values to create new object
    SpringApplication.run(QuickstartDemoApplication.class, args);
  }

  // #DESERIALIZATION START

  @GetMapping("/user")
  public User getUserAbstract() {
    return USER_ABSTRACT;
  }

  @PostMapping("/user")
  public User postUserAbstract(@RequestBody User proposedUser) {
    USER_ABSTRACT = proposedUser;
    return USER_ABSTRACT;
  }

  // #DESERIALIZATION END

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

  @GetMapping("/status/simple")
  public Status getSimpleStatus() {
    return PLAYER_STATUS;
  }

  @PostMapping("/status/simple")
  public Status postSimpleStatus(final Status proposedStatus) {

    PLAYER_STATUS = proposedStatus;

    return PLAYER_STATUS;
  }

  private String detailedStatus = "No Detailed Status Set";

  @GetMapping("/status/detailed")
  public String getDetailedStatus() {
    return this.detailedStatus;
  }

  @PostMapping(path = "/status/detailed", consumes ="text/plain")
  public String postDetailedStatus(@RequestBody String detailedStatus) {

    this.detailedStatus = detailedStatus;

    return this.detailedStatus;
  }
}
