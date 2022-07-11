package com.spring.rest._3_1_5;

import com.spring.rest._3_1_5.configuration.MyConfig;
import com.spring.rest._3_1_5.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Transmitter transmitter = context.getBean("transmitter", Transmitter.class);

        //Список пользователей
        List<User> allUsers = transmitter.getAllUsers();
        System.out.println(allUsers);

        //Добавление пользователей
        User user = new User(3L, "James", "Brown", (byte) 25);
        transmitter.addUser(user);

        //Изменение пользователя
        User changedUser = new User(3L, "Thomas", "Shelby", (byte) 25);
        transmitter.updateUser(changedUser);

        //Удаление пользователя
        transmitter.deleteUser(changedUser,3L);

        //Вывод результирующей строки
        System.out.println(transmitter.getSb());
    }
}
