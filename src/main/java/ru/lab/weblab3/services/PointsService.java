package ru.lab.weblab3.services;

import ru.lab.weblab3.models.dao.impls.PointDAOImpl;
import ru.lab.weblab3.models.dao.PointsDAO;
import ru.lab.weblab3.models.entities.Point;
import ru.lab.weblab3.services.checkers.Field;
import ru.lab.weblab3.services.factories.PointFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "pointsService", eager = true)
@SessionScoped //todo мб апликатион
public class PointsService implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double currentX;
    private Double currentY;
    private Double currentR;

    private PointsDAO pointsDAO;
    private PointFactory pointFactory;


    public PointsService() {
        pointsDAO = new PointDAOImpl();
        pointFactory = PointFactory.getInstance(new Field());
    }

    public void addPoint() {
        Point point = pointFactory.buildPoint("1.0", "1.0", "1.0");
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

    public void setCurrentR(Double currentR) {
        this.currentR = currentR;
    }

    public Double getCurrentX() {
        return currentX;
    }

    public Double getCurrentY() {
        return currentY;
    }

    public Double getCurrentR() {
        return currentR;
    }
}
