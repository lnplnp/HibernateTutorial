package org.hibernate.tutorial.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

  private static Logger log = LoggerFactory.getLogger(HibernateUtil.class);

  private static final SessionFactory sessionFactory = buildSessionFactory();

  @SuppressWarnings("deprecation")
  private static SessionFactory buildSessionFactory() {
    log.debug("");
    try {
      // Create the SessionFactory from hibernate.cfg.xml
      return new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) {
      // Make sure you log the exception, as it might be swallowed
      log.error("Initial SessionFactory creation failed : {}", ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    log.debug("");
    return sessionFactory;
  }

}
