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
 * The type Test validate name.
 */
public class TestValidateName  {

    /**
     * The Vn.
     */
    ValidateName vn;

    /**
     * Pre condition.
     */
    @Before
  public void preCondition(){
    vn = ValidateName.getInstance();
  }

    /**
     * Test get descriptor rules validation.
     */
    @Test
  public void testGetDescriptorRulesValidation() {
    String desc ="The nick must contain:" + System.lineSeparator() +
      "- the initial CAPITAL" + System.lineSeparator() +
      "- lowercase letters and numbers" + System.lineSeparator() +
      "- min 3 characters" + System.lineSeparator() +
      "- max 25 characters" + System.lineSeparator();

    assertEquals(desc, vn.getRulesOfValidation());
  }

    /**
     * Gets pattern.
     */
    @Test
  public void getPattern() {
    assertEquals("^[A-Z]{1,}[a-z0-9]{3,25}$",
      vn.getPattern());
  }

    /**
     * Gets validator name.
     */
    @Test
  public void getValidatorName() {
    assertEquals("Username",
      vn.getValidatorName());
  }

    /**
     * The type Test validate number with input.
     */
    @RunWith(Parameterized.class)
  public static class TestValidateNumberWithInput {

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
         * The Vnp.
         */
        private ValidateName vnp= ValidateName.getInstance();

        /**
         * Instantiates a new Test validate number with input.
         *
         * @param str  the str
         * @param bool the bool
         */
        public TestValidateNumberWithInput(String str, boolean bool) {
      this.str  = str;
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
        new Object[] {"AAA",      false},
        new Object[] {"As23.",    false},
        new Object[] {"Assd0",    true},
        new Object[] {"\0",       false},
        new Object[] {"A0ds",     true},
        new Object[] {null,       false},
        new Object[] {"-..s23s",  false},
        new Object[] {"Asds34fdsfsdfsdfsdfsdfsdfsdfsdsdfsdsdfdsfsdfsdfsdfsdfsdf",  false});
    }

        /**
         * Testis valid.
         */
        @Test
    public void testisValid() {
      assertEquals(vnp.isValid(str), bool);
    }
  }
}