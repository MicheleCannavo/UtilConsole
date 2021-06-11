package org.example.util.validator;

/**
 * The type Validate email.
 */

/**
 * Demonstration for PlantUML.
 * <p>
 * Example of use:
 * <p>
 * <img src="doc-files/image1.png" alt="">
 */
/*
 * @startuml doc-files/image1.png
 * Bob -> Alice : hello
 * Alice --> Bob : OK
 * @enduml
 */
public final class ValidateEmail extends AbstractValidator {

    /**
     * The constant instance.
     */
    private static ValidateEmail instance = null;

    /**
     * Instantiates a new Validate email.
     */
    private ValidateEmail() {
    nameValidator   = "e-mail";
    pattern         = "^[a-zA-Z0-9\\.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]{2,4}$";
    validationRules = "Indirizzo Valido";
  }

    /**
     * Get instance validate email.
     *
     * @return l 'unica instance della classe.
     */
    public static ValidateEmail getInstance(){

    if(null == instance){
      instance=new ValidateEmail();
    }
    return instance;
  }
}