/**
 * 
 */
package org.hibernate.tutorial.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Manuel
 * 
 */
public class Person {

  private Long id;
  private int age;
  private String firstname;
  private String lastname;

  public Set<Event> events = new HashSet<Event>();

  /**
   * 
   */
  public Person() {
  }

  public Set<Event> getEvents() {
    return this.events;
  }

  public void setEvents(Set<Event> events) {
    this.events = events;
  }

  public Long getId() {
    return id;
  }

  @SuppressWarnings("unused")
  private void setId(Long id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

}
