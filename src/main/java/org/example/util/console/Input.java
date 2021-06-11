package org.example.util.console;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Questa classe gestisce i possibili metodi
 * di input su console e non.
 *
 * @author Michele Cannavo'
 * @version 0.8.0
 * @since 0.8.0
 */
public final class Input {

  /**
   * Instantiates a new Input.
   */
  private Input() { }

  /**
   * Legge un input, da System.in, come stringa.
   *
   * @param format the format
   * @param args   the args
   * @return the string
   * @since 0.6.0
   */
  public static String readLine(String format, Object... args) {
    try {
      return System.console().readLine(format, args);
    } catch(Exception ex) {
      System.out.printf(format, args);
      return new Scanner(new InputStreamReader(System.in)).nextLine();
    }
  }

  /**
   * Legge da console una password, senza mostrarne i caratteri a video
   *
   * @return la password immessa.
   */
  public static String readPassword() {
    try {
      return Arrays.toString(System.console().readPassword("password: "));
    } catch(Exception ex) {
      return readLine("password: ");
    }
  }

}
