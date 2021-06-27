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

package it.mik.validator.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Validate name project.
 */
public final class ValidateNameProject extends AbstractValidator {

  /**
   * LOGGER
   */
  private static final Logger LOGGER =
    LoggerFactory.getLogger(ValidateNameProject.class);

  /**
   * The constant instance.
   */
  private static ValidateNameProject instance = null;

  /**
   * Instantiates a new Validate name project.
   */
  private ValidateNameProject() {

    setNameValidator("ProjectName");
    setPattern("^[A-Z]{1,}[a-zA-Z0-9]{2,24}$");
    setValidationRules(
      "The project name must contain:" + System.lineSeparator() +
        "- Begin with a CAPITAL letter " + System.lineSeparator() +
        "- At least one lowercase letter" + System.lineSeparator() +
        "- At least one number" + System.lineSeparator() +
        "- Min 3 characters" + System.lineSeparator() +
        "- Max 25 characters" + System.lineSeparator());

    LOGGER.debug("Create instance with \nName:{} - Pattern:{} - Rules:{}",
      getValidatorName(), getPattern(), getRulesOfValidation());
  }

  /**
   * {@inheritDoc}
   *
   * @return the instance
   */
  public static ValidateNameProject getInstance() {

    if (null == instance) {
      instance = new ValidateNameProject();
    }
    return instance;
  }
}