/*------------------------------------------------------------------------------
 - Copyright (c) 2021 Cannavo' Michele. All right reserved.
 -
 -  This file is part of UtilConsole
 -
 -     UtilConsole is free software: you can redistribute it and/or modify
 -     it under the terms of the Lesser GNU General Public License as published by
 -     the Free Software Foundation, either version 3 of the License, or
 -     (at your option) any later version.
 -
 -     UtilConsole is distributed in the hope that it will be useful,
 -     but WITHOUT ANY WARRANTY; without even the implied warranty of
 -     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 -     Lesser GNU General Public License for more details.
 -
 -     You should have received a copy of the Lesser GNU General Public License
 -     along with UtilConsole.  If not, see <http://www.gnu.org/licenses/>.
 -----------------------------------------------------------------------------*/
package org.example.util.console;

import java.io.IOException;

/**
 * Classe per gestione dei metodi.
 *
 * @brief Classe per gestione dei metodi
 * per le console.
 *
 * @author    Michele Cannavo'
 * @copyright ©2021 - Michele Cannavo'
 * @license   LGPL 3.0
 * @mod       17/05/2021, Cannavo' Michele
 * @since     1.0.0
 * @version   1.3.0
 *
 */
public final class Console {

  /**
   * Costruttore privato
   */
  private Console() {  }

  /**
   * Metodo che azzera lo Stream.out usato.
   * Nel caso delle console "pulisce" la console.
   * In caso di errore termina il metodo.
   *
   * @since 1.0.0
   */
  @SuppressWarnings("unused")
  public static void clrscr() {

    try {
      if(System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        Runtime.getRuntime().exec("clear");
      }
    } catch(IOException | InterruptedException | NullPointerException ex) {
      ex.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }
}