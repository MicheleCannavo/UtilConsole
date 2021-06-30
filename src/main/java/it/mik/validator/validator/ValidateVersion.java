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
import static java.lang.System.lineSeparator;

/**
 * The type Validate version.
 *
 * @since 1.2.0
 */
public final class ValidateVersion extends AbstractValidator {
    /**
     *
     */
    private static final Logger LOGGER =
      LoggerFactory.getLogger(ValidateVersion.class);
    /**
     * The constant instance.
     */
    private static ValidateVersion instance ;

    /**
     * Instantiates a new Validate version.
     */
    private ValidateVersion() {    setNameValidator("version number");
        setPattern("^([0-9]+)\\.([0-9]+)\\.([0-9]+)(?:-([0-9A-Za-z-]+(?:\\.[0-9A-Za-z-]+)*))?(?:\\+[0-9A-Za-z-]+)?$");
        setValidationRules("The format must be X.Y.Z[[-pre_release][+build]] :" +
                "- X -> MAJOR version"  + lineSeparator() +
                "- Y -> MINOR version"  + lineSeparator() +
                "- Z -> PATCH version"  + lineSeparator() +
                "- - pre-release "      + lineSeparator() +
                "- + build metadata"    + lineSeparator()) ;
        LOGGER.debug("Create instance with \nName:{} - Pattern:{} - Rules:{}",
          getValidatorName(), getPattern(), getRulesOfValidation());
    }

    /**
     * Get instance validate version.
     *
     * @return the validate version
     */
    public static synchronized ValidateVersion getInstance(){

        if(null == instance){
            instance = new ValidateVersion();
        }
        return instance;
    }
}