package ru.lab.weblab3.services;

import ru.lab.weblab3.models.dao.impls.PointDAOImpl;
import ru.lab.weblab3.models.entities.Point;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        PointDAOImpl pointDAO = new PointDAOImpl();
        Point point = new Point(1.0, 2.0,1.0);
        point.setHit(true);
        return "Hello World!";
    }
}
