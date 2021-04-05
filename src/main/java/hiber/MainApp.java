package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user = new User("Dmitriy", "Ushin", "post@gmail.com");
      Car car = new Car("Toyota GT86", 1);
      user.setCar(car);

      User user1 = new User("Nastya", "Osipova", "nast@koshka.myau");
      Car car1 = new Car("Mercedes A", 1);
      user1.setCar(car1);

      User user2 = new User("Andrey", "Demicov", "and@gmail.com");
      Car car2 = new Car("Volkswagen scirocco", 2);
      user2.setCar(car2);

      User user3 = new User("Albert", "Budagyan", "alb@gmail.com");
      Car car3 = new Car("Mercedes W220", 2);
      user3.setCar(car3);

      User carUser = new User("name", "lastName", "email");
      Car hisCar = new Car("model", 5);
      carUser.setCar(hisCar);

      userService.add(user);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(carUser);

      for(User u : userService.listUsers()) {
         System.out.println(u);
         System.out.println("-----------------------------------------------");
      }

      User userByCar = userService.getUserByCar( "model", 5);
      System.out.println(userByCar);

      context.close();
   }
}
