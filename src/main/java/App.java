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

import it.mik.validator.validator.AbstractValidator;
import it.mik.validator.validator.ValidateGeneric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.console.Output;

/**
 * Hello world!
 */
public class App {
  private static final Logger LOGGER  =
    LoggerFactory.getLogger(App.class);
  /**
   *
   */
  private App() {
  }

  /**
   * @param args A
   */
  public static void main(String[] args) {

    AbstractValidator vb = new ValidateGeneric("r", "[0-9]");
    Output.printnlLine(vb.getPattern());
    vb.isValid(null);
    vb.isValid("2");
  }
}
