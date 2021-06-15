package org.example.util.validator;

/**
 * The type Validate password.
 */
public final class ValidatePassword extends AbstractValidator {

  /**
   * The constant instance.
   */
  private static ValidatePassword instance = null;

  /**
   * Classe con soli metodi statici
   */
  private ValidatePassword(){
    setNameValidator("password");
    setPattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,8}$");
    setValidationRules("La password deve contenere:" + System.lineSeparator() +
                    "- Una lettera MAIUSCOLA"     + System.lineSeparator()  +
                    "- Una lettera minuscola"     + System.lineSeparator()  +
                    "- Un numero"                 + System.lineSeparator()  +
                    "- min 4 caratteri"           + System.lineSeparator()  +
                    "- max 8 caratteri"           + System.lineSeparator());
  }

  /**
   * {@inheritDoc}
   *
   * @return the validate password
   */
  public static ValidatePassword getInstance(){
    if(null == instance){
      instance = new ValidatePassword();
    }
    return instance;
  }
}