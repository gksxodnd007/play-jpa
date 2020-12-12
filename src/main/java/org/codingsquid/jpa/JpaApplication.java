package org.codingsquid.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO Check persist context when just new entity()
//TODO Check open in session view
//TODO Check transaction isolation in JPA
//TODO Check find entity twice before and after other transaction committed
//TODO Check @EmbbededId
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

}
