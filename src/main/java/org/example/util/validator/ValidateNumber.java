package org.example.util.validator;

/**
 * The type Validate number.
 */
public final class ValidateNumber extends AbstractValidator {

  /**
   * The constant instance.
   */
  private static ValidateNumber instance = null;

  /**
   * Classe con soli metodi statici
   */
  private ValidateNumber(){
    setNameValidator("number");
    setPattern("^[0-9]+$");
    setValidationRules("");
  }

  /**
   * {@inheritDoc}
   *
   * @return the validate number
   */
  public static ValidateNumber getInstance(){

    if(null == instance){
      instance=new ValidateNumber();
    }
    return instance;
  }

}