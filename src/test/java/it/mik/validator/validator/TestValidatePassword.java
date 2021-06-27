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

package it.mik.validator.validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * The type Test validate password.
 */
public class TestValidatePassword {

    /**
     * The Vp.
     */
    ValidatePassword vp;

    /**
     * Pre condition.
     */
    @Before
  public void preCondition(){
    vp = ValidatePassword.getInstance();
  }

    /**
     * Test get descriptor rules validation.
     */
    @Test
  public void testGetDescriptorRulesValidation() {
    String desc =
      "Password must contain:" + System.lineSeparator() +
        "- A capital letter"   + System.lineSeparator()  +
        "- A lowercase letter" + System.lineSeparator()  +
        "- A number"           + System.lineSeparator()  +
        "- min 4 characters"   + System.lineSeparator()  +
        "- max 8 characters"   + System.lineSeparator();

    assertEquals(desc, vp.getRulesOfValidation());
  }

    /**
     * Gets pattern.
     */
    @Test
  public void getPattern() {
    assertEquals("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,8}$",
      vp.getPattern());
  }

    /**
     * Gets validator name.
     */
    @Test
  public void getValidatorName() {
    assertEquals("password",
      vp.getValidatorName());
  }


    /**
     * The type Testis valid.
     */
    @RunWith(Parameterized.class)
  public static class TestisValid {


        /**
         * The System in mock.
         */
        @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
        /**
         * The Str.
         */
        private final String str;
        /**
         * The Bool.
         */
        private final boolean bool;
        /**
         * The Vp.
         */
        private ValidatePassword vp = ValidatePassword.getInstance();

        /**
         * Instantiates a new Testis valid.
         *
         * @param str  the str
         * @param bool the bool
         */
        public TestisValid(String str, boolean bool) {
      this.str = str;
      this.bool = bool;
    }

        /**
         * Gets param.
         *
         * @return the param
         */
        @Parameterized.Parameters
    public static Collection<Object[]> getParam() {
      return Arrays.asList(
        new Object[] {"Aaa003",        true},
        new Object[] {"Gs6",           false},
        new Object[] {"---",           false},
        new Object[] {"\0",            false},
        new Object[] {"3",             false},
        new Object[] {"AAss23s",       true},
        new Object[] {"Asds34fAS3423", false},
        new Object[] {"SdfsdSDFSD",    false},
        new Object[] {"0DSFSDSD00",    false},
        new Object[] {"A m8",          false},
          new Object[] {null, false},
        new Object[] {"4assas854",     false});
    }

        /**
         * Test validate password.
         */
        @Test
    public void testValidatePassword() {
      System.out.println(str);
      assertEquals(vp.isValid(str), bool);
    }

  }
}