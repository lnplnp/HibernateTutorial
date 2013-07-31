/**
 * 
 */
package fr.manuel.name;

/**
 * @author Manuel
 * 
 */
public class LastNameProvider extends NameProvider {

  public LastNameProvider() {
    namesProvider = "src/main/resources/noms.txt";
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    NameProvider nameProvider;
    nameProvider = new LastNameProvider();
    System.out.println(nameProvider.getName());
    System.out.println(nameProvider.getName());
    System.out.println(nameProvider.getName());
  }

}
