package fr.manuelpayet.name;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LastName extends Name {

  private static Logger log = LoggerFactory.getLogger(LastName.class);

  public LastName() {
    log.debug("");
  }

  public LastName(String label) {
    log.debug("public LastName(String {})", label);
    setLabel(label);
  }

  @Override
  public Long getId() {
    log.debug("public String getId() > {}", id);
    return this.id;
  }

  @Override
  public String getLabel() {
    log.debug("public String getLabel() > {}", label);
    return this.label;
  }

  @Override
  public void setLabel(String label) {
    log.debug("public void setLabel(String {})", label);
    this.label = label;
  }

}
