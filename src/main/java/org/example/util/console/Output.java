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

import java.util.Arrays;

/**
 * Classe per gestione degli OUTPUT
 * per lo SYSTEM_OUT.
 *
 * @author    Michele Cannavo'
 * @copyright © 2021 - Cannavo' Michele
 * @license   LGPL 3.0
 * @date      10/06/2021
 * @since     1.0.0
 * @version   1.3.0
 * @mod       12/06/2021, Add printIsPresent(String item)
 */
public final class Output {

  /**
   * Classe statica.
   */
  private Output() {
  }

  /**
   * Stampa una stringa senza lineSeparator() finale.
   *
   * @param format Il formato della stringa.
   * @param args   Gli argomenti della stringa.
   *
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
   * @param format Il formato della stringa.
   * @param args   Gli argomenti della stringa.
   *
   * @since 1.0.0
   */
  public static void printnlLine(String format, Object... args) {
    printLine(format+ System.lineSeparator(), Arrays.toString(args) );
  }

  /**
   * Stampa la stringa "input non valido".
   * Dopo va a capo.
   *
   * @since 1.1.0
   */
  public static void printNotValid() {
    var notValid = "input non valido";
    printnlLine(notValid);
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
    printnlLine(notValid);
  }
}