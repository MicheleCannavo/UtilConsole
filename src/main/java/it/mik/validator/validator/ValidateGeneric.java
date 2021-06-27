
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
 * This class allows you to validate a generic object
 */
public class ValidateGeneric extends AbstractValidator {

    private static final Logger LOGGER =
      LoggerFactory.getLogger(ValidateGeneric.class);

    /**
     * Constructor for validating a generic object.
     * It expects two parameters corresponding
     * to the name of the validator which should coincide
     * with the type of the object to be validated,
     * And with the validation regex rules.
     *
     * @param nameValidator    Name of the validator.
     * @param patternValidator Validation pattern.
     */
    public ValidateGeneric(String nameValidator, String patternValidator) {

        setNameValidator(nameValidator);
        setPattern(patternValidator);
        setValidationRules("");

        LOGGER.debug("Create instance with \nName:{} - Pattern:{}",
           nameValidator, patternValidator);
    }

}