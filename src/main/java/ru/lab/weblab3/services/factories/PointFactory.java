package ru.lab.weblab3.services.factories;

import ru.lab.weblab3.models.entities.Point;
import ru.lab.weblab3.services.checkers.HitChecker;

public class PointFactory {
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

    public Point buildPoint(String xValue, String yValue, String rValue) {
        Point p1 = new Point(1.0, 2.0, 3.0);
        p1.setHit(true);
        return p1;
    }
}
