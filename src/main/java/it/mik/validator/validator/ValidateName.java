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
 * The type Validate name.
 */
public final class ValidateName extends AbstractValidator {

    private static final Logger LOGGER =
      LoggerFactory.getLogger(ValidateName.class);

    /**
     * The constant instance.
     */
    private static ValidateName instance ;

    /**
     * Costruttore privato per Validate name.
     * Setta:
     * @attribute nameValidator    nome utente
     * @attribute pattern          ^[A-Z]{1,}[a-z0-9]{3,25}$
     * @attribute validationRules  Il nick deve contenere:
     * - l' iniziale MAIUSCOLA
     * - lettere minuscoli e numeri
     * - min 3 caratteri
     * - max 25 caratteri
     */
    private ValidateName() {
        setNameValidator("Username");
        setPattern("^[A-Z]{1,}[a-z0-9]{3,25}$");
        setValidationRules("The nick must contain:" + System.lineSeparator() +
                "- the initial CAPITAL" + System.lineSeparator() +
                "- lowercase letters and numbers" + System.lineSeparator() +
                "- min 3 characters" + System.lineSeparator() +
                "- max 25 characters" + System.lineSeparator());
        LOGGER.debug("Create instance with \nName:{} - Pattern:{} - Rules:{}",
          getValidatorName(), getPattern(), getRulesOfValidation());
    }

    /**
     * Singleton.
     *
     * @return the only possible instance.
     */
    public static synchronized ValidateName getInstance() {

        if (null == instance) {
            instance = new ValidateName();
        }
        return instance;
    }
}