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
 * The type Validate number.
 */
public final class ValidateNumber extends AbstractValidator {

  /**
   * LOGGER
   */
  private static final Logger LOGGER =
    LoggerFactory.getLogger(ValidateNumber.class);

  /**
   * The constant instance.
   */
  private static ValidateNumber instance = null;

  /**
   *
   */
  private ValidateNumber(){
    setNameValidator("number");
    setPattern("^[0-9]+$");
    setValidationRules("");

    LOGGER.debug("Create instance with \nName:{} - Pattern:{} - Rules:{}",
      getValidatorName(), getPattern(), getRulesOfValidation());
  }

  /**
   * {@inheritDoc}
   *
   * @return the validate number
   */
  public static ValidateNumber getInstance(){

    if(null == instance){
      instance = new ValidateNumber();
    }
    return instance;
  }

}