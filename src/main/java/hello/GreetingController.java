package hello;

import java.util.ArrayList;
import org.springframework.ui.Model;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/greetings")
  public ArrayList<Greeting> greeting(Model model) {
    model.addAttribute("greetings", Application.arrGreetings);
    return Application.arrGreetings;
  }

  @RequestMapping("/greetings/add")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    Greeting newGreeting = new Greeting(counter.incrementAndGet(), String.format(template, name)); //create the new Greeting object
    Application.arrGreetings.add(newGreeting); //add the new Greeting to the list

    return newGreeting;
  }
  
}