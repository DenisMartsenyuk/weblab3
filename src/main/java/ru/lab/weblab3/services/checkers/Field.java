package ru.lab.weblab3.services.checkers;

public final class Field implements HitChecker {
    @Override
    public boolean isHit(Double x, Double y, Double r) {
        if (x <= 0 && y >= 0 && (4 * x * x <= r * r) && y <= r) {
            return true;
        }

        if (x >= 0 && y >= 0 && 2 * y <= r - 2 * x) {
            return true;
        }

        if(x >= 0 && y <= 0 && (4 * x * x + 4 * y * y <= r * r)) {
            return true;
        } //todo опять переписать

        return false;
    }
}
