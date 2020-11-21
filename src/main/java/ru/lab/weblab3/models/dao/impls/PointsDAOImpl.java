package ru.lab.weblab3.models.dao.impls;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.lab.weblab3.models.dao.PointsDAO;
import ru.lab.weblab3.models.entities.Point;
import ru.lab.weblab3.services.checkers.HitChecker;
import ru.lab.weblab3.services.factories.HibernateSessionFactory;

import java.util.List;

public class PointsDAOImpl implements PointsDAO {
    private static volatile PointsDAO instance;

    private PointsDAOImpl() {
    }

    public static PointsDAO getInstance() {
        PointsDAO result = instance;
        if (result != null) {
            return result;
        }
        synchronized(PointsDAOImpl.class) {
            if (instance == null) {
                instance = new PointsDAOImpl();
            }
            return instance;
        }
    }

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
        session.createQuery("delete from Point").executeUpdate(); //todo перейти от запроса к jpa  и аннотация Transaction
        tx1.commit();
        session.close();
    }

    @Override
    public List<Point> getAll() {
        List<Point> points = (List<Point>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery("From Point").list();
        return points;
    }
}
