package fr.manuelpayet.name;

public class FirstName extends Name {

  public FirstName() {

  }

  public FirstName(String label) {
    setLabel(label);
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public String getLabel() {
    return this.label;
  }

  @Override
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
