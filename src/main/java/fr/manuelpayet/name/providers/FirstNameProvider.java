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
public class FirstNameProvider extends NameProvider {

  private static Logger log = LoggerFactory.getLogger(NameProvider.class);

  public FirstNameProvider() {
    log.debug("");
    namesProvider = "src/main/resources/prenoms.txt";
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    log.debug("");
    NameProvider nameProvider = new FirstNameProvider();
    System.out.println(nameProvider.getName());
    System.out.println(nameProvider.getName());
    System.out.println(nameProvider.getName());
  }

}
