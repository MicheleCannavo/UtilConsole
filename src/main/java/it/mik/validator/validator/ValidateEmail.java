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
 * Demonstration for PlantUML.
 */
public final class ValidateEmail extends AbstractValidator {

    private static final Logger LOGGER =
      LoggerFactory.getLogger(ValidateEmail.class);

    /**
     * Private builder for Validate email.
     * Setta:<br />
     *
     * @attribute nameValidator: e-mail<br />
     * @attribute pattern:  ^[a-zA-Z0-9\\.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]{2,4}$<br />
     * @attribute validationRules:   Valid address<br><br />
     */
    private static ValidateEmail instance ;

    /**
     * Instantiates a new Validate email.
     */
    private ValidateEmail() {
        setNameValidator("e-mail");
        setPattern("^[a-zA-Z0-9\\.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]{2,4}$");
        setValidationRules("Valid address");
        LOGGER.debug("Create instance with \nName:{} - Pattern:{} - Rules:{}",
          getValidatorName(), getPattern(), getRulesOfValidation());
     }/**/


    /**
     * Get instance validate email.
     *
     * @return The only instance of the class.
     */
    public static synchronized ValidateEmail getInstance() {

        if (null == instance) {
            instance = new ValidateEmail();
        }
        return instance;
    }
}