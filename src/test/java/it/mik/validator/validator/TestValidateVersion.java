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

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * The type Test validate version.
 */
public class TestValidateVersion {

    /**
     * The Vn.
     */
    ValidateVersion vn;

    /**
     * Pre condition.
     */
    @Before
    public void preCondition() {
        vn = ValidateVersion.getInstance();
    }

    /**
     * Test get descriptor rules validation.
     */
    @Test
    public void testGetDescriptorRulesValidation() {
        String desc = "The format must be X.Y.Z[[-pre_release][+build]] :" +
            "- X -> MAJOR version"  + lineSeparator() +
            "- Y -> MINOR version"  + lineSeparator() +
            "- Z -> PATCH version"  + lineSeparator() +
            "- - pre-release "      + lineSeparator() +
            "- + build metadata"    + lineSeparator();

        assertEquals(desc, vn.getRulesOfValidation());
    }

    /**
     * Gets pattern.
     */
    @Test
    public void getPattern() {
        assertEquals("^([0-9]+)\\.([0-9]+)\\.([0-9]+)(?:-([0-9A-Za-z-]+(?:\\.[0-9A-Za-z-]+)*))?(?:\\+[0-9A-Za-z-]+)?$",
            vn.getPattern());
    }

    /**
     * Gets validator name.
     */
    @Test
    public void getValidatorName() {
        assertEquals("version number",
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
         * The Vv.
         */
        private ValidateVersion vv = ValidateVersion.getInstance() ;

        /**
         * Instantiates a new Test validate number with input.
         *
         * @param str  the str
         * @param bool the bool
         */
        public TestValidateNumberWithInput(String str, boolean bool) {
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
                new Object[]{"1.2-AA", false},
                new Object[]{"A.1.223", false},
                new Object[]{"1.2.3", true},
                new Object[]{"0.0.3", true},
                new Object[]{"1.2.3-release", true},
                new Object[]{"1.2.3+build", true},
                new Object[]{"1.2.3-release+build", true},
                new Object[]{"\0", false},
                new Object[]{"1.2+builf", false},
                new Object[]{"-build+release", false},
                new Object[] {null, false},
                new Object[]{"Asds34fdsfsdf", false});
        }


        /**
         * Test validate password.
         */
        @Test
        public void testValidatePassword() {
            System.out.println(str);
            assertEquals(vv.isValid(str), bool);
        }
    }
}