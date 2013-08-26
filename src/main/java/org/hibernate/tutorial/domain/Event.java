package org.hibernate.tutorial.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Event {
  private static Logger log = LoggerFactory.getLogger(Event.class);

  private Long id;

  private String title;
  private Date date;

  private Set<Person> participants = new HashSet<Person>();

  public Event() {
    log.debug("");
  }

  public Long getId() {
    log.debug("");
    return id;
  }

  @SuppressWarnings("unused")
  private void setId(Long id) {
    log.debug("");
    this.id = id;
  }

  public Date getDate() {
    log.debug("");
    return date;
  }

  public void setDate(Date date) {
    log.debug("");
    this.date = date;
  }

  public String getTitle() {
    log.debug("");
    return title;
  }

  public void setTitle(String title) {
    log.debug("");
    this.title = title;
  }

  public Set<Person> getParticipants() {
    log.debug("");
    return participants;
  }

  public void setParticipants(Set<Person> participants) {
    log.debug("");
    this.participants = participants;
  }
}
