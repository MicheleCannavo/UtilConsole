
package org.example.util.console;

import java.io.IOException;

/**
 * Classe per gestione dei metodi.
 *
 * @brief Classe per gestione dei metodi
 * per le console.
 *
 * @author    Michele Cannavo'
 *
 * @copyright ©2021 - Michele Cannavo'
 * @lic       LGPL 3.0
 * @mod       17/05/2021, Cannavo' Michele
 * @since     1.0.0
 * @version   1.0.0
 *
 */
public final class Console {

  /**
   * Il costruttore privato impedisce
   * la creazione di istanze di classe
   */
  private Console() {  }

  /**
   * Metodo che pulisce la util usata.
   *
   * @since 0.6.0
   */
  public static void clrscr() {

    try {
      if(System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        Runtime.getRuntime().exec("clear");
      }
    } catch(IOException | InterruptedException ex) {
      ex.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }
}