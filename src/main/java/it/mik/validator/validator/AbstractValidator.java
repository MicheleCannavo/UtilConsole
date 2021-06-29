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

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.console.Input;
import util.console.Output;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public abstract class AbstractValidator {

  /**
   * Logger
   */
  private static final Logger LOGGER =
    LoggerFactory.getLogger(AbstractValidator.class);

  /**
   * The Pattern.
   */
  private String pattern = "";

  /**
   * The Name validator.
   */
  private String nameValidator = "";

  /**
   * The Validation rules.
   */
  private String validationRules = "";

  /**
   * Sets name validator.
   *
   * @param nameValidator the name validator
   */
  public void setNameValidator(String nameValidator) {
    this.nameValidator = (nameValidator == null) ? "anonymous" : nameValidator;
  }

  /**
   * Gets validation rules.
   *
   * @return the validation rules
   */
  public String getValidationRules() {
    return validationRules;
  }

  /**
   * Sets validation rules.
   *
   * @param validationRules the validation rules
   */
  public void setValidationRules(String validationRules) {
    this.validationRules = (validationRules == null) ? "" : validationRules;
  }

  /**
   * Returns the Regex to compare with strings
   *
   * @return Regex
   */
  public String getPattern() {
    return this.pattern;
  }

  /**
   * Sets pattern.
   *
   * @param pattern the pattern
   */
  public void setPattern(String pattern) {
    if (null == pattern) {
      LOGGER.error("Regex is null");
      throw new PatternSyntaxException("Regex is null", null, -1);
    }
    this.pattern = pattern;
  }

  /**
   * Returns a string with the validation element of the class.
   *
   * @return Name object to validate.
   * @since 0.6.0
   */
  public String getValidatorName() {
    return this.nameValidator;
  }

  /**
   * Gets descriptor rules validation.
   *
   * @return the descriptor rules validation.
   */
  public String getRulesOfValidation() {
    return this.validationRules;
  }

  /**
   * Input a string and check if matches of regex validation.
   *
   * @param string Regex
   * @return true if so, no if not.
   */
  public boolean isValid(@NotNull String string) {
    LOGGER.debug("Validation {{}} with:{}", string, getPattern());
    boolean result;
    result = Pattern.matches(getPattern(), string);
    LOGGER.debug("The result of the validation is: {}", result);
    return result;

  }


  /**
   * Request via keyboard input.
   * <p>
   * If the input doesn't match the validator regex,
   * you will be asked to re-enter the string again.
   * If an empty string is entered (ENTER),
   * the request will still be exited.
   *
   * @return The input entered.
   */
  public String request() {
    var tmpString = Input.readLine("Inserire " + getValidatorName() + " ");
    LOGGER.debug("Value entered: {}", tmpString);
    while (!isValid(tmpString) || tmpString.isEmpty()) {
      LOGGER.warn("Entry error");
      Output.printNotValid();
      Output.printnlLine(getRulesOfValidation());
      tmpString = Input.readLine("Re-insert " + getValidatorName() + " ");
      LOGGER.debug("Value entered: {}\\\\", tmpString);
    }
    return tmpString;
  }
}