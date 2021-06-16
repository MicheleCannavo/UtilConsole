package org.example.util.validator;

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
        String desc = "Il formato deve essere X.Y.Z[[-pre_release][+build]] :" +
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
        assertEquals("numero di versione",
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