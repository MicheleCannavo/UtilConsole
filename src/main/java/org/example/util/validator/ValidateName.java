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
     * Instantiates a new Validate name.
     */
    private ValidateName() {

        /**
         * @param nameValidator nome utente
         */
        nameValidator = "nome utente";

        /**
         * @param pattern ^[A-Z]{1,}[a-z0-9]{3,25}$
         */
        pattern = "^[A-Z]{1,}[a-z0-9]{3,25}$";

        /**
         * @param validationRules
         * Il nick deve contenere:
         *- l' iniziale MAIUSCOLA
         *- lettere minuscoli e numeri
         *- min 3 caratteri
         *- max 25 caratteri
         */
        validationRules = "Il nick deve contenere:" + System.lineSeparator() +
                "- l' iniziale MAIUSCOLA" + System.lineSeparator() +
                "- lettere minuscoli e numeri" + System.lineSeparator() +
                "- min 3 caratteri" + System.lineSeparator() +
                "- max 25 caratteri" + System.lineSeparator();
  }

    /**
     * Singleton.
     *
     * @return l 'unica istanza possibile.
     */
    public static ValidateName getInstance(){

    if(null == instance){
      instance=new ValidateName();
    }
    return instance;
  }
}