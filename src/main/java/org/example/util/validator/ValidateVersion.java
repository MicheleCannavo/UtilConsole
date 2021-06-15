
package org.example.util.validator;

import static java.lang.System.lineSeparator;

/**
 * The type Validate version.
 *
 * @since 1.2.0
 */
public final class ValidateVersion extends AbstractValidator {

    /**
     * The constant instance.
     */
    private static ValidateVersion instance = null;

    /**
     * Instantiates a new Validate version.
     */
    private ValidateVersion() {    setNameValidator("numero di versione");
        setPattern("^([0-9]+)\\.([0-9]+)\\.([0-9]+)(?:-([0-9A-Za-z-]+(?:\\.[0-9A-Za-z-]+)*))?(?:\\+[0-9A-Za-z-]+)?$");
        setValidationRules("Il formato deve essere X.Y.Z[[-pre_release][+build]] :" +
                "- X -> MAJOR version"  + lineSeparator() +
                "- Y -> MINOR version"  + lineSeparator() +
                "- Z -> PATCH version"  + lineSeparator() +
                "- - pre-release "      + lineSeparator() +
                "- + build metadata"    + lineSeparator()) ;
    }

    /**
     * Get instance validate version.
     *
     * @return the validate version
     */
    public static ValidateVersion getInstance(){

        if(null == instance){
            instance = new ValidateVersion();
        }
        return instance;
    }
}