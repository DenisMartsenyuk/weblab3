package ru.lab.weblab3.services;

import ru.lab.weblab3.models.dao.PointsDAO;
import ru.lab.weblab3.models.dao.impls.PointsDAOImpl;
import ru.lab.weblab3.models.entities.Point;
import ru.lab.weblab3.services.checkers.Field;
import ru.lab.weblab3.services.factories.PointFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

@ManagedBean(name = "pointsService", eager = true)
@SessionScoped
public class PointsService {

    private Double currentX;
    private Double currentY;

    private Double clickX;
    private Double clickY;

    private Boolean is1R;
    private Boolean is2R;
    private Boolean is3R;
    private Boolean is4R;
    private Boolean is5R;
    private List<Double> rValues;

    private PointsDAO pointsDAO;
    private PointFactory pointFactory;


    public PointsService() {
        pointsDAO = PointsDAOImpl.getInstance();
        pointFactory = PointFactory.getInstance(new Field());
        rValues = Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0);

        currentX = -4.0;
        is1R = true;
    }

    public void addPoint() {
        Point point = pointFactory.buildPoint(currentX, currentY, getCurrentR());
        pointsDAO.addPoint(point);
    }

    public void addClickedPoint() {
        Point point = pointFactory.buildPoint(clickX, clickY, getCurrentR());
        pointsDAO.addPoint(point);
    }

    public void clear() {
        pointsDAO.clear();
    }

    public List<Point> getPoints() {
        return pointsDAO.getAll();
    }

    public void setCurrentX(Double currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(Double currentY) {
        this.currentY = currentY;
    }

    public Double getCurrentX() {
        return currentX;
    }

    public Double getCurrentY() {
        return currentY;
    }

    public Double getClickX() {
        return clickX;
    }

    public void setClickX(Double clickX) {
        this.clickX = clickX;
    }

    public Double getClickY() {
        return clickY;
    }

    public void setClickY(Double clickY) {
        this.clickY = clickY;
    }

    private Double getCurrentR() {
        if (is1R) {
            return rValues.get(0);
        }
        if (is2R) {
            return rValues.get(1);
        }
        if (is3R) {
            return rValues.get(2);
        }
        if (is4R) {
            return rValues.get(3);
        }
        if (is5R) {
            return rValues.get(4);
        }
        return null;
    }

    public Boolean getIs1R() {
        return is1R;
    }

    public void setIs1R(Boolean is1R) {
        this.is1R = is1R;
        this.is2R = false;
        this.is3R = false;
        this.is4R = false;
        this.is5R = false;
    }

    public Boolean getIs2R() {
        return is2R;
    }

    public void setIs2R(Boolean is2R) {
        this.is2R = is2R;
        this.is1R = false;
        this.is3R = false;
        this.is4R = false;
        this.is5R = false;
    }

    public Boolean getIs3R() {
        return is3R;
    }

    public void setIs3R(Boolean is3R) {
        this.is3R = is3R;
        this.is1R = false;
        this.is2R = false;
        this.is4R = false;
        this.is5R = false;
    }

    public Boolean getIs4R() {
        return is4R;
    }

    public void setIs4R(Boolean is4R) {
        this.is4R = is4R;
        this.is1R = false;
        this.is2R = false;
        this.is3R = false;
        this.is5R = false;
    }

    public Boolean getIs5R() {
        return is5R;
    }

    public void setIs5R(Boolean is5R) {
        this.is5R = is5R;
        this.is1R = false;
        this.is2R = false;
        this.is3R = false;
        this.is4R = false;
    }
}
