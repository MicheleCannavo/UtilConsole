
package org.example.util.console;

import java.util.Arrays;

/**
 * Classe per gestione degli OUTPUT
 * per lo SYSTEM_OUT.
 *
 * @author Michele Cannavo'
 * @version 1.1.0
 * change Add printIsPresent(String item)
 * @since 1.0.0
 */
public final class Output {

  /**
   * Instantiates a new Output.
   */
  private Output() {
  }

  /**
   * Stampa una stringa senza lineSeparator() finale.
   *
   * @param format the format
   * @param args   the args
   * @since 1.0.0
   */
  public static void printLine(String format, Object... args) {

    try{
      System.console().printf(format, args);
    } catch(NullPointerException ex) {
      System.out.printf(format, Arrays.toString(args));
    }
  }

  /**
   * Stampa una stringa con lineSeparator() finale.
   *
   * @param format the format
   * @param args   the args
   * @since 1.0.0
   */
  public static void printnlLine(String format, Object... args) {
    printLine(format+ System.lineSeparator(), Arrays.toString(args) );
  }


  /**
   * Stampa la stringa "input non valido".
   * Dopo va a capo.
   *
   * @since 1.0.0
   */
  public static void printNotValid() {
    String notValid = "input non valido";
    try{
      System.console().printf(notValid+System.lineSeparator());
    } catch(Exception ex) {
      System.out.println(notValid);
    }
  }

  /**
   * Stampa la stringa "item + " è già presente".
   * Dopo va a capo.
   *
   * @param item l' item già presente.
   * @since 1.1.0
   */
  public static void printIsPresent(String item) {
    String notValid = item + " e' gia' presente";
    try{
      System.console().printf(notValid+System.lineSeparator());
    } catch(Exception ex) {
      System.out.println(notValid);
    }
  }
}
