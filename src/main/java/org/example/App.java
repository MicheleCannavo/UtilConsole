
package org.example;


import org.example.util.console.Input;
import org.example.util.console.Output;
import org.example.util.validator.*;

/**
 * Hello world!
 *
 */
public class App 
{

    /**
     *
     */
    public App() {
    }

    /**
     *
     * @param args A
     */
    public static void main( String[] args )    {
        AbstractValidator vn = ValidateNumber.getInstance();
        Output.printnlLine(Boolean.toString(vn.isValid("11d2")));
        vn = ValidateEmail.getInstance();
        Output.printnlLine(Boolean.toString(vn.isValid("sdsf@1l.oi")));
        String g= Input.readLine("");
        Output.printLine("Inserito: ["+g+"]");
    }
}
