
package org.example.util.validator;

/**
 * Questa classe permette di validare un oggetto
 */
public class ValidateGeneric extends AbstractValidator {

    /**
     * Costruttore per la validazione di un oggetto generico.
     * Si aspetta due parametri corrispondenti al nome del validatore
     * che dovrebbe coincidere con il tipo dell' oggetto da validare,
     * e con le regole regex di validazione.
     *
     * @param nameValidator    Nome del validatore.
     * @param patternValidator Pattern di validazione.
     */
    public ValidateGeneric(String nameValidator, String patternValidator) {
        setNameValidator(nameValidator);
        setPattern(patternValidator);
        setValidationRules("");
    }

}