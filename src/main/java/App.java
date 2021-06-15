/*------------------------------------------------------------------------------
 - Copyright (c) 2021 Cannavo' Michele. All right reserved.
 -
 -  This file is part of UtilConsole
 -
 -     UtilConsole is free software: you can redistribute it and/or modify
 -     it under the terms of the Lesser GNU General Public License as published by
 -     the Free Software Foundation, either version 3 of the License, or
 -     (at your option) any later version.
 -
 -     UtilConsole is distributed in the hope that it will be useful,
 -     but WITHOUT ANY WARRANTY; without even the implied warranty of
 -     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 -     Lesser GNU General Public License for more details.
 -
 -     You should have received a copy of the Lesser GNU General Public License
 -     along with UtilConsole.  If not, see <http://www.gnu.org/licenses/>.
 -----------------------------------------------------------------------------*/

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
    private App(){}
    /**
     *
     * @param args A
     */
    public static void main( String[] args )    {
        AbstractValidator vn = ValidateEmail.getInstance();
        Output.printnlLine(String.valueOf(vn.isValid("Aldo@l.it")));
        Output.printnlLine(String.valueOf(vn.isValid("a23ldo@iu.fgu")));
        Output.printnlLine(String.valueOf(vn.isValid("-Ald3o")));
        Output.printnlLine(String.valueOf(vn.isValid("Aldowr")));

    }
}
