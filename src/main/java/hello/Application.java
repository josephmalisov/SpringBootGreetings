package hello;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static int counter = 0;

  public static ArrayList<Greeting> arrGreetings = new ArrayList<Greeting>();
  public static void main(String[] args) {
    
    SpringApplication.run(Application.class, args);
  }
}