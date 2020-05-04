package dao;

import dao.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

public class DAOHelpers {
    public static <T> T ExecuteInSession(Function<Session,  T> handler) throws SQLException {
        Session session = null;
        T result;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = handler.apply(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("error in ExecuteInSession method: " + e);
        } finally {
            if (session != null && session.isOpen()) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
                session.close();
            }
        }
        return result;
    }

    public static void ExecuteInSessionVoidRet(Consumer<Session> consumer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            consumer.accept(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new SQLException("error in ExecuteInSessionVoidRet method: " + e);
        } finally {
            if (session != null && session.isOpen()) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
                session.close();
            }
        }
    }
}