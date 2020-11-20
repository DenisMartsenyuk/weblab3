package ru.lab.weblab3.models.entities;

import javax.persistence.*;

@Entity
@Table (name = "points")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "x")
    private Double x;

    @Column (name = "y")
    private Double y;

    @Column (name = "r")
    private Double r;

    @Column (name = "hit")
    private Boolean hit;

    public Point(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    protected Point() {
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    public Boolean getHit() {
        return hit;
    }

    public Double getR() {
        return r;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setR(Double r) {
        this.r = r;
    }
}
