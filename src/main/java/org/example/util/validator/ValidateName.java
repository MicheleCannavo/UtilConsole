package org.example.util.validator;


/**
 * The type Validate name.
 */
public final class ValidateName extends AbstractValidator {


    /**
     * The constant instance.
     */
    private static ValidateName instance = null;

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
        setNameValidator("nome utente");
        setPattern("^[A-Z]{1,}[a-z0-9]{3,25}$");
        setValidationRules("Il nick deve contenere:" + System.lineSeparator() +
                "- l' iniziale MAIUSCOLA" + System.lineSeparator() +
                "- lettere minuscoli e numeri" + System.lineSeparator() +
                "- min 3 caratteri" + System.lineSeparator() +
                "- max 25 caratteri" + System.lineSeparator());
    }

    /**
     * Singleton.
     *
     * @return l 'unica istanza possibile.
     */
    public static ValidateName getInstance() {

        if(null == instance) {
            instance = new ValidateName();
        }
        return instance;
    }
}