package fr.manuel.name;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class NameProvider {

  protected String namesProvider = null;

  private Set<String> names;

  public String getName() {
    names = new HashSet<String>();

    try {
      // Open the file that is the first command line parameter
      FileInputStream fstream = new FileInputStream(namesProvider);
      // Get the object of DataInputStream
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String name;
      // Read File Line By Line
      while ((name = br.readLine()) != null) {
        names.add(name.trim());
      }
      // Close the input stream
      in.close();
    } catch (Exception e) {// Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }

    Object[] namesArray = names.toArray();
    Random random = new Random();
    int nextInt = random.nextInt(namesArray.length);
    String name = (String) namesArray[nextInt];
    return name;
  }

}
