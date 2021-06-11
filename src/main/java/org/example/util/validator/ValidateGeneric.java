package org.example.util.validator;

/**
 * Questa classe permette di validareun oggetto
 */
public class ValidateGeneric extends AbstractValidator {

    /**
     * Costruttore per la validazione di un oggetto generico.
     * Si aspetta due parametri corrispondenti al nome del validatore
     * che dovrebbe coincidere con il tipo dell'oggetto da validare,
     * e con le regole regex di validazione.
     *
     * @param nameValidator    Nome Validatore.
     * @param patternValidator Pattern di validazione.
     */
    public ValidateGeneric(String nameValidator, String patternValidator) {
    this.nameValidator   = nameValidator;
    this.pattern         = patternValidator;
    this.validationRules = "";
  }

    /**
     * Questo metodo permette di descrivere
     * le regole di validazione qualora ci fosse bisogno.
     *
     * @param rules regole descrittive di validazione.
     */
    public void setValidationRules(String rules) {
    this.validationRules = (rules==null? "" : rules);
  }

}