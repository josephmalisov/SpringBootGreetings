package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(value = "/")
	public String index() {
		return "index";
	}

  @RequestMapping("/greetings")
  public ArrayList<Greeting> greeting() {
    return Application.arrGreetings;
  }

  @RequestMapping("/greetings/add")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    Greeting newGreeting = new Greeting(counter.incrementAndGet(), String.format(template, name)); //create the new Greeting object
    Application.arrGreetings.add(newGreeting); //add the new Greeting to the list

    return newGreeting;
  }
  
}