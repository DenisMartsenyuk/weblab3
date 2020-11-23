package ru.lab.weblab3.models.dao;

import ru.lab.weblab3.models.entities.Point;

import java.util.List;

public interface PointsDAO {
    Point addPoint(Point point); //todo return Point
    Boolean clear(); //todo return bool
    List<Point> getAll();
}
