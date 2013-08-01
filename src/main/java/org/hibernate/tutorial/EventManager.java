package org.hibernate.tutorial;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

import fr.manuel.name.FirstNameProvider;
import fr.manuel.name.LastNameProvider;

public class EventManager {

  public static void main(String[] args) {
    EventManager mgr = new EventManager();

    FirstNameProvider firstNameProvider = new FirstNameProvider();
    LastNameProvider lastNameProvider = new LastNameProvider();
    if (args[0].equals("store")) {
      for (int i = 0; i < 10; i++) {
        String firstName = firstNameProvider.getName();
        String lastName = lastNameProvider.getName();
        mgr.createAndStorePerson(firstName, lastName);
        mgr.createAndStoreEvent("My Event" + System.currentTimeMillis(), new Date());
      }
    } else if (args[0].equals("list")) {
      List<?> events = mgr.listEvents();
      for (int i = 0; i < events.size(); i++) {
        Event theEvent = (Event) events.get(i);
        System.out.println("Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate());
      }
    } else if (args[0].equals("addpersontoevent")) {
      Long eventId = null;
      Long personId = null;

      eventId = mgr.createAndStoreEvent("My Event" + System.currentTimeMillis(), new Date());
      personId = mgr.createAndStorePerson(firstNameProvider.getName(), lastNameProvider.getName());
      mgr.addPersonToEvent(personId, eventId);
      System.out.println("1. Added person " + personId + " to event " + eventId);

      eventId = mgr.createAndStoreEvent("My Event" + System.currentTimeMillis(), new Date());
      personId = mgr.createAndStorePerson(firstNameProvider.getName(), lastNameProvider.getName());
      mgr.addPersonToEvent2(personId, eventId);
      System.out.println("2. Added person " + personId + " to event " + eventId);
    } else if (args[0].equals("addpersontoevent2")) {
      for (int i = 0; i < 10; i++) {
        mgr.addRandomExistingPersonToRandomExistingEvent();
      }
      System.out.println("Added a Random Existing Person To a Random Existing Event");
    } else if (args[0].equals("addemailtoperson")) {
      String firstName = firstNameProvider.getName();
      String lastName = lastNameProvider.getName();
      Long personId = mgr.createAndStorePerson(firstName, lastName);
      for (int i = 0; i < 3; i++) {
        String emailAddress = String.format("%s.%s.%s@host.fr", firstName, lastName, System.currentTimeMillis());
        mgr.addEmailToPerson(personId, emailAddress);
        System.out.println("Added person " + personId + " and his email " + emailAddress);
      }
    }

    HibernateUtil.getSessionFactory().close();
  }

  private Long createAndStorePerson(String firstName, String lastName) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();

    Person thePerson = new Person();
    thePerson.setFirstname(firstName);
    thePerson.setLastname(lastName);
    thePerson.setAge(firstName.length() + lastName.length());
    session.save(thePerson);

    session.getTransaction().commit();
    return thePerson.getId();
  }

  private List<?> listEvents() {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    List<?> result = session.createQuery("from Event").list();
    session.getTransaction().commit();
    return result;
  }

  private Long createAndStoreEvent(String title, Date theDate) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();

    Event theEvent = new Event();
    theEvent.setTitle(title);
    theEvent.setDate(theDate);
    session.save(theEvent);

    session.getTransaction().commit();
    return theEvent.getId();
  }

  private void addRandomExistingPersonToRandomExistingEvent() {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();

    Person aPerson = (Person) session.createSQLQuery("SELECT * FROM persons ORDER BY RAND() LIMIT 1").addEntity(Person.class).list().get(0);
    Event anEvent = (Event) session.createSQLQuery("SELECT * FROM events ORDER BY RAND() LIMIT 1").addEntity(Event.class).list().get(0);

    aPerson.getEvents().add(anEvent);

    session.getTransaction().commit();
  }

  private void addPersonToEvent(Long personId, Long eventId) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();

    Person aPerson = (Person) session.load(Person.class, personId);
    Event anEvent = (Event) session.load(Event.class, eventId);
    aPerson.getEvents().add(anEvent);

    session.getTransaction().commit();
  }

  private void addEmailToPerson(Long personId, String emailAddress) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();

    Person aPerson = (Person) session.load(Person.class, personId);
    // adding to the emailAddress collection might trigger a lazy load of the
    // collection
    aPerson.getEmailAddresses().add(emailAddress);

    session.getTransaction().commit();
  }

}
