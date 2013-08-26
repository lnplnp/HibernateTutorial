package fr.manuelpayet.name;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstName extends Name {

  private static Logger log = LoggerFactory.getLogger(FirstName.class);

  public FirstName() {
    log.debug("");
  }

  public FirstName(String label) {
    log.debug("public FirstName(String {})", label);
    setLabel(label);
  }

  @Override
  public Long getId() {
    log.debug("public Long getId() > {}", this.id);
    return this.id;
  }

  @Override
  public String getLabel() {
    log.debug("public Long getLabel() > {}", this.label);
    return this.label;
  }

  @Override
  public void setLabel(String label) {
    log.debug("public void setLabel(String {})", label);
    this.label = label;
  }

}
