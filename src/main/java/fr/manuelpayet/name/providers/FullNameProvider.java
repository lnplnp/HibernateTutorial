package fr.manuelpayet.name.providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FullNameProvider {

  private static Logger log = LoggerFactory.getLogger(FullNameProvider.class);

  /**
   * @param args
   */
  public static void main(String[] args) {
    log.debug("");
    for (int i = 0; i < 10; i++) {
      FullNameProvider fullNameProvider = new FullNameProvider();
      log.info(fullNameProvider.getName());
    }
  }

  private final String fname;

  private final String lname;

  public FullNameProvider() {
    log.debug("");
    fname = new FirstNameProvider().getName();
    lname = new LastNameProvider().getName();
  }

  private String getName() {
    log.debug("");
    return getName(true);
  }

  private String getName(boolean firstNameBefore) {
    log.debug("");
    return firstNameBefore ? this.fname + " " + this.lname : this.lname + " " + this.fname;
  }
}
