package main;

import dao.*;
import java.sql.SQLException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) throws SQLException {
        ContactDAO _dao;
        SessionFactory s;
        Transaction tx;

        s = new Configuration().configure().buildSessionFactory();
        tx = s.getCurrentSession().beginTransaction();
        _dao = new ContactDAO();
        _dao.setSessionFactory(s);

        System.out.println(_dao.getByCustomerId((long)2).get(0).getEmail());

        tx.commit();
        s.close();
    }
}