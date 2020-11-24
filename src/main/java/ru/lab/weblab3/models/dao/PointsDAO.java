package ru.lab.weblab3.models.dao;

import ru.lab.weblab3.models.entities.Point;

import java.util.List;

public interface PointsDAO {
    Point addPoint(Point point);
    Boolean clear();
    List<Point> getAll();
}
