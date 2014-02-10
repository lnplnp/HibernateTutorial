package fr.manuelpayet.name;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Name {

  private static Logger log = LoggerFactory.getLogger(Name.class);

  protected Long id;

  protected String label;

  public abstract Long getId();

  public abstract String getLabel();

  @SuppressWarnings("unused")
  private void setId(Long id) {
    log.debug("private void setId(Long {})", id);
    this.id = id;
  }

  public abstract void setLabel(String label);

}
