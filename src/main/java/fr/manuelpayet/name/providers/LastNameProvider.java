/**
 * 
 */
package fr.manuelpayet.name.providers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manuel
 * 
 */
public class LastNameProvider extends NameProvider {

  private static Logger log = LoggerFactory.getLogger(NameProvider.class);

  public LastNameProvider() {
    log.debug("");
    namesProvider = "src/main/resources/noms.txt";
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    log.debug("");
    NameProvider nameProvider = new LastNameProvider();
    System.out.println(nameProvider.getName());
    System.out.println(nameProvider.getName());
    System.out.println(nameProvider.getName());
  }

}
