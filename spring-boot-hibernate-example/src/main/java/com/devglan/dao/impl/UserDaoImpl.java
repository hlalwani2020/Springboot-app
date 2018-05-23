package com.devglan.dao.impl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;

import com.devglan.dao.UserDao;
import com.devglan.model.UserDetails;

@Component("UserDao")
public class UserDaoImpl implements UserDao {

    private static ServiceRegistry serviceRegistry;
    private static SessionFactory factory;
    @Autowired

    private SessionFactory sessionFactory;


    public List<UserDetails> getUserDetails() {
        Criteria criteria = sessionFactory.openSession().createCriteria(UserDetails.class);
        return criteria.list();
    }

    @SuppressWarnings("deprecation")
    public List<UserDetails> setUserDetails(int id, String name, double height, double weight) {
        addAllConfigs();
        return getUserDetails();
    }


    public static void addAllConfigs() {
        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(UserDetails.class);
        config.addResource("bmi.hbm.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);
    }

    private long insertBMIdata(int id, String name, double height, double weight) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer stId = null;
        try {
            tx = session.beginTransaction();
            UserDetails st = new UserDetails();
            st.setId(id);
            st.setname(name);
            st.setheight(height);
            st.setweight(weight);

            stId = (Integer) session.save(st);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
        } finally {
            session.close();
        }

        return stId;
    }
}
