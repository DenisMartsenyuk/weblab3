package ru.lab.weblab3.models.dao;

import ru.lab.weblab3.models.entities.Point;

import java.util.List;

public interface PointsDAO {
    void addPoint(Point point);
    void clear();
    List<Point> getAll();
}
