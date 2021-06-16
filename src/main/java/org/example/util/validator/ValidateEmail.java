package org.example.util.validator;

/**
 * Demonstration for PlantUML.
 */
public final class ValidateEmail extends AbstractValidator {

    /**
     * Costruttore privato per Validate email.
     * Setta:<br />
     *
     * @attribute nameValidator: e-mail<br />
     * @attribute pattern:  ^[a-zA-Z0-9\\.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]{2,4}$<br />
     * @attribute validationRules:   Indirizzo Valido<br><br />
     */
    private static ValidateEmail instance = null;

    /**
     * Instantiates a new Validate email.
     */
    private ValidateEmail() {
        setNameValidator("e-mail");
        setPattern("^[a-zA-Z0-9\\.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]{2,4}$");
        setValidationRules("Indirizzo Valido");
    }

    /**
     * Get instance validate email.
     *
     * @return l 'unica instance della classe.
     */
    public static ValidateEmail getInstance() {

        if (null == instance) {
            instance = new ValidateEmail();
        }
        return instance;
    }
}