package ua.lviv.iot.DB_Lab.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.iot.DB_Lab.util.HibernateUtil;

import java.util.List;

public class GeneralRepo<T> {

    private final Class<T> typeParameterClass;

    public GeneralRepo(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    public T findOne(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(typeParameterClass,id);
    }

    public void save(T model) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(model);
        transaction.commit();
        session.close();
    }


    public void update(T model) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(model);
        transaction.commit();
        session.close();
    }

    public void delete(T model) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(model);
        transaction.commit();
        session.close();
    }

    public List<T> findAll() {
        List<T> users = (List<T>)  HibernateUtil.getSessionFactory().openSession().createQuery("From " + typeParameterClass.getCanonicalName()).list();
        return users;
    }
}
