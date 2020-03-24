package org.db.dao;

import org.db.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

public class DAOHelpers {
    public static <T> T ExecuteInSession(Function<Session,  T> handler, Boolean transaction) throws SQLException {
        Session session = null;
        T result;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            if (transaction) {
                session.beginTransaction();
            }
            result = handler.apply(session);
            if (transaction) {
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            throw new SQLException("error in ExecuteInSession method: " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public static void ExecuteInSessionVoidRet(Consumer<Session> consumer, Boolean transaction) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            if (transaction) {
                session.beginTransaction();
            }
            consumer.accept(session);
            if (transaction) {
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            throw new SQLException("error in ExecuteInSessionVoidRet method: " + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
