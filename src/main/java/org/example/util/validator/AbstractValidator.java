package org.example.util.validator;

import org.example.util.console.Input;
import org.example.util.console.Output;

/**
 * Questa interfaccia permette la validazione di una Stringa
 * con l' elemento oggetto della classe
 *
 * @author      Cannavo' Michele
 * @copyright   © 2021 - Cannavo' Michele
 * @license         LGPL 3.0
 * @date        10/06/2021
 * @version     1.3.0
 * @since       1.0.0
 * @mod         12/06/2021
 */
public abstract class AbstractValidator {

    /**
     * The Pattern.
     */
    private String pattern = "";

    /**
     * The Name validator.
     */
    private String nameValidator = "";

    /**
     * The Validation rules.
     */
    private String validationRules = "";


    /**
     * Sets pattern.
     *
     * @param pattern the pattern
     */
    public void setPattern(String pattern) {
        this.pattern = (pattern == null) ? "" : pattern;
    }


    /**
     * Sets name validator.
     *
     * @param nameValidator the name validator
     */
    public void setNameValidator(String nameValidator) {
        this.nameValidator = (nameValidator == null) ? "" : nameValidator;
    }

    /**
     * Gets validation rules.
     *
     * @return the validation rules
     */
    public String getValidationRules() {
        return validationRules;
    }

    /**
     * Sets validation rules.
     *
     * @param validationRules the validation rules
     */
    public void setValidationRules(String validationRules) {
        this.validationRules = (validationRules == null) ? "" : validationRules;
    }

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
     *
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
     *
     * @return true se in caso affermativo, no al contrario
     */
    public boolean isValid(String string) {
        return string != null && string.matches(this.pattern);
    }

    /**
     * Richiesta tramite input da tastiera.
     *
     * Se l'input non matcha con la regex del validatore,
     * verrà chiesto di reinserire nuovamente la stringa.
     * Se immessa una stringa vuota (INVIO), si uscirà
     * comunque dalla richiesta.
     *
     *
     * @return L' input inserito.
     */
    public String request() {
        String tmpString;
        tmpString = Input.readLine("Inserire " + getValidatorName() + " ");

        while (!isValid(tmpString) || tmpString.isEmpty()) {
            Output.printNotValid();
            Output.printnlLine(getRulesOfValidation());
            tmpString = Input.readLine("RE-Inserire " + getValidatorName() + " ");
        }
        return tmpString;
    }
}