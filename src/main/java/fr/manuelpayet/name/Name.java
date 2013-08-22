package fr.manuelpayet.name;

public abstract class Name {

  protected Long id;

  protected String label;

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public abstract Long getId();

  @SuppressWarnings("unused")
  private void setId(Long id) {
    this.id = id;
  }

  public abstract String getLabel();

  public abstract void setLabel(String label);

}
