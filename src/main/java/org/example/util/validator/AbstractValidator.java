package org.example.util.validator;

import org.example.util.console.Input;
import org.example.util.console.Output;

/**
 * Questa interfaccia permette la validazione di una Stringa con l' elemento oggetto della classe
 *
 * @author Cannavo ' Michele
 * @version 0.6.0
 * @since 0.6.0
 */
public abstract class AbstractValidator {

    /**
     * The Pattern.
     */
    protected String pattern = "";

    /**
     * The Name validator.
     */
    protected String nameValidator = "";

    /**
     * The Validation rules.
     */
    protected String validationRules = "";

    /**
     * Restituisce la Regex con cui confrontare le stringhe
     *
     * @return la Regex
     */
    public String getPattern() {
    return this.pattern;
  }

    /**
     * Restituisce una stringa con l' elemento della validazione della classe.
     *
     * @return Name oggetto da validare.
     * @since 0.6.0
     */
    public String getValidatorName() {
    return this.nameValidator;
  }

    /**
     * Gets descriptor rules validation.
     *
     * @return the descriptor rules validation
     */
    public String getRulesOfValidation() {
    return this.validationRules;
  }

    /**
     * Prende in Input una stringa e controlla se corrisponde alla sintassi della Regex di validazione.
     *
     * @param string La Regex
     * @return true se in caso affermativo, no al contrario
     */
    public boolean isValid(String string) {
    return string != null && string.matches(this.pattern);
  }

    /**
     * Richiesta generica.
     *
     * @return  L' input inserito.
     */
    public String request() {
    String tmpString = Input.readLine("Inserire " + getValidatorName() + " ");

     while( isValid(tmpString) ){
      Output.printNotValid();
      Output.printnlLine(getRulesOfValidation());
      Output.printLine("RE-");
      tmpString = Input.readLine("Inserire " + getValidatorName() + " ");
    }
    return  tmpString;
  }
}