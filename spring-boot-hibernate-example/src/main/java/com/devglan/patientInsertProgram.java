package com.devglan;


import com.devglan.model.UserDetails;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class patientInsertProgram {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;

    @SuppressWarnings("deprecation")
    public static void main(String[] args)
    {
        addAllConfigs();

        patientInsertProgram hi = new patientInsertProgram();
        long one = hi.insertBMIdata(1," Mark Johnson", "154", "63");
        long two = hi.insertBMIdata(1," Arjun Khandelwal", "154", "67");

        System.out.println(" We successfully inserted students in student table...they are..." + one + " and " + two);
    }

    public static void addAllConfigs()
    {
        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(UserDetails.class);
        config.addResource("bmi.hbm.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        factory = config.buildSessionFactory(serviceRegistry);
    }

    private long insertBMIdata(int id, String name, String height, String weight)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer stId = null;
        try
        {
            tx = session.beginTransaction();
            UserDetails st = new UserDetails();
            st.setId(id);
            st.setname(name);
            st.setheight(height);
            st.setweight(weight);

            stId = (Integer) session.save(st);
            tx.commit();
        }
        catch (HibernateException ex)
        {
            if(tx != null)
                tx.rollback();
        }
        finally
        {
            session.close();
        }

        return stId;
    }
}