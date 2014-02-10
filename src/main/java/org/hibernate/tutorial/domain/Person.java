/**
 * 
 */
package org.hibernate.tutorial.domain;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manuel
 * 
 */
public class Person {

  private static Logger log = LoggerFactory.getLogger(Person.class);

  private Long id;
  private int age;
  private String firstname;
  private String lastname;

  public Set<Event> events = new HashSet<Event>();

  private Set<String> emailAddresses = new HashSet<String>();

  /**
   * 
   */
  public Person() {
    log.debug("");
  }

  public void addToEvent(Event event) {
    log.debug("");
    this.getEvents().add(event);
    event.getParticipants().add(this);
  }

  public int getAge() {
    log.debug("");
    return age;
  }

  public Set<String> getEmailAddresses() {
    log.debug("");
    return emailAddresses;
  }

  public Set<Event> getEvents() {
    log.debug("");
    return this.events;
  }

  public String getFirstname() {
    log.debug("");
    return firstname;
  }

  public Long getId() {
    log.debug("");
    return id;
  }

  public String getLastname() {
    log.debug("");
    return lastname;
  }

  public void removeFromEvent(Event event) {
    log.debug("");
    this.getEvents().remove(event);
    event.getParticipants().remove(this);
  }

  public void setAge(int age) {
    log.debug("");
    this.age = age;
  }

  public void setEmailAddresses(Set<String> emailAddresses) {
    log.debug("");
    this.emailAddresses = emailAddresses;
  }

  public void setEvents(Set<Event> events) {
    log.debug("");
    this.events = events;
  }

  public void setFirstname(String firstname) {
    log.debug("");
    this.firstname = firstname;
  }

  @SuppressWarnings("unused")
  private void setId(Long id) {
    log.debug("");
    this.id = id;
  }

  public void setLastname(String lastname) {
    log.debug("");
    this.lastname = lastname;
  }
}
