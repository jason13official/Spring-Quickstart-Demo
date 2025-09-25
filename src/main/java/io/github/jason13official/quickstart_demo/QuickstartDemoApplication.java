package io.github.jason13official.quickstart_demo;

import io.github.jason13official.quickstart_demo.impl.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link RestController} is for annotating endpoints/port listeners that should be available
 * with web requests (TCP/UDP?)
 */
@SpringBootApplication
@RestController
public class QuickstartDemoApplication {

	// so we don't create a new record every request
	private static final Person JASON = new Person("Jason", 25);

	public static void main(String[] args) {

		// runs the specified source using default settings; DI of default values to create new object
		SpringApplication.run(QuickstartDemoApplication.class, args);
	}

	/**
	 * Quite a lot to unpack here...
	 * <br />
	 * {@link GetMapping} maps requests to `/hello` (i.e. `http://localhost:8080/hello`)
	 * <br />
	 * {@link RequestParam} expects a value, but provides a safe default if no value was passed
	 */
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/person")
	public String person() {
		return asH1(JASON.toPrettyString());
	}

	private static String asH1(String s) {
		return "<h1>" + s + "</h1>";
	}
}
