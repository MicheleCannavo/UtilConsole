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
 * The type Validate password.
 */
public final class ValidatePassword extends AbstractValidator {

  private static final Logger LOGGER =
    LoggerFactory.getLogger(ValidatePassword.class);
  /**
   * The constant instance.
   */
  private static ValidatePassword instance ;

  /**
   * Class with static methods only
   */
  private ValidatePassword(){
    setNameValidator("password");
    setPattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,8}$");
    setValidationRules("Password must contain:" + System.lineSeparator() +
                    "- A capital letter"     + System.lineSeparator()  +
                    "- A lowercase letter"     + System.lineSeparator()  +
                    "- A number"                 + System.lineSeparator()  +
                    "- min 4 characters"           + System.lineSeparator()  +
                    "- max 8 characters"           + System.lineSeparator());
    LOGGER.debug("Create instance with \nName:{} - Pattern:{} - Rules:{}",
      getValidatorName(), getPattern(), getRulesOfValidation());
  }

  /**
   * {@inheritDoc}
   *
   * @return the validate password
   */
  public static synchronized ValidatePassword getInstance(){
    if(null == instance){
      instance = new ValidatePassword();
    }
    return instance;
  }
}