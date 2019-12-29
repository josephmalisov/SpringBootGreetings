package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greetings")
  public String greeting(Model model) {
    model.addAttribute("greetings", Application.arrGreetings);
    return "greetings";
  }

  @PostMapping("/greetings")
  public String greetingSubmit(@ModelAttribute Greeting greeting) {
    //Greeting newGreeting = new Greeting(counter.incrementAndGet(), String.format(template, name)); //create the new Greeting object
    Application.arrGreetings.add(greeting); //add the new Greeting to the list
    //model.addAttribute("name", name); //used to display the name in the HTML
    return "result";
  }
  
}