package org.example.util.validator;

/**
 * The type Validate name project.
 */
public final class ValidateNameProject extends AbstractValidator {


    /**
     * The constant instance.
     */
    private static ValidateNameProject instance = null;

    /**
     * Instantiates a new Validate name project.
     */
    private ValidateNameProject() {


    setNameValidator("nome progetto");
    setPattern("^[A-Z]{1,}[a-zA-Z0-9]{2,24}$");
    setValidationRules(
      "Il nome progetto deve contenere:"     + System.lineSeparator() +
      "- Iniziare con una lettera MAIUSCOLA" + System.lineSeparator() +
      "- Una lettera minuscola"              + System.lineSeparator() +
      "- Un numero"                          + System.lineSeparator() +
      "- min 3 caratteri"                    + System.lineSeparator() +
      "- max 25 caratteri"                   + System.lineSeparator());
  }

    /**
     * {@inheritDoc}
     *
     * @return the instance
     */
    public static ValidateNameProject getInstance() {

    if(null == instance) {
      instance = new ValidateNameProject();
    }
    return instance;
  }
}