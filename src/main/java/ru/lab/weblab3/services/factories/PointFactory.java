package ru.lab.weblab3.services.factories;

import ru.lab.weblab3.models.entities.Point;
import ru.lab.weblab3.services.checkers.HitChecker;

public class PointFactory { //todo EJB
    private static PointFactory instance;

    private final HitChecker field;

    private PointFactory(HitChecker field) {
        this.field = field;
    }

    public static PointFactory getInstance(HitChecker field) {
        if (instance == null) {
            instance = new PointFactory(field);
        }
        return instance;
    }

    public Point buildPoint(Double x, Double y, Double r) {
        Point point = new Point(x, y, r);
        point.setHit(field.isHit(x, y, r));
        return point;
    }
}
