package ru.lab.weblab3.services.checkers;

public final class Field implements HitChecker {
    @Override
    public boolean isHit(Double x, Double y, Double r) {
        if (x <= 0 && y >= 0 && (x * x <= r * r) && y <= r) {
            return true;
        }

        if (x >= 0 && y >= 0 && (x * x + y * y <= r * r)) {
            return true;
        }

        if(x >= 0 && y <= 0 && (-y <= r - x)) {
            return true;
        }

        return false;
    }
}
