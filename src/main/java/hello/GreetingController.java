package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/greetings")
  public String greeting(Model model) {
    model.addAttribute("greetings", Application.arrGreetings);
    return "greetings";
  }

  @RequestMapping("/greetings/add")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, Model model) {
    Greeting newGreeting = new Greeting(counter.incrementAndGet(), String.format(template, name)); //create the new Greeting object
    Application.arrGreetings.add(newGreeting); //add the new Greeting to the list
    model.addAttribute("name", name); //used to display the name in the HTML
    return newGreeting;
  }
  
}