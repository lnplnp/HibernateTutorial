/**
 * 
 */
package fr.manuelpayet.name.providers;

/**
 * @author Manuel
 * 
 */
public class FirstNameProvider extends NameProvider {

  public FirstNameProvider() {
    namesProvider = "src/main/resources/prenoms.txt";
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    NameProvider nameProvider;
    nameProvider = new FirstNameProvider();
    System.out.println(nameProvider.getName());
    System.out.println(nameProvider.getName());
    System.out.println(nameProvider.getName());
  }

}
