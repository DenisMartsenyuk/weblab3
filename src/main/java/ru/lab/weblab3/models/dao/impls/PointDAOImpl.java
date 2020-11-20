package ru.lab.weblab3.models.dao.impls;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.lab.weblab3.models.dao.PointsDAO;
import ru.lab.weblab3.models.entities.Point;
import ru.lab.weblab3.services.factories.HibernateSessionFactory;

import java.util.List;

public class PointDAOImpl implements PointsDAO { //todo мб тоже синглтон
    @Override
    public void addPoint(Point point) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(point);
        tx1.commit();
        session.close();
    }

    @Override
    public void clear() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createQuery("delete from Point").executeUpdate();
        tx1.commit();
        session.close();
    }

    @Override
    public List<Point> getAll() {
        List<Point> points = (List<Point>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Point").list();
        return points;
    }
}
