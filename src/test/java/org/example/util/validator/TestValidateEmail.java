package org.example.util.validator;

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
 * The type Test validate email.
 */
public class TestValidateEmail {
    /**
     * The Ve.
     */
    ValidateEmail ve;

    /**
     * Pre condition.
     */
    @Before
  public void preCondition(){
    ve = ValidateEmail.getInstance();
  }

    /**
     * Test get descriptor rules validation.
     */
    @Test
  public void testGetDescriptorRulesValidation() {
    assertEquals("Indirizzo Valido",
      ve.getValidationRules());
  }

    /**
     * Test get pattern.
     */
    @Test
  public void testGetPattern() {
    assertEquals("^[a-zA-Z0-9\\.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]{2,4}$",
      ve.getPattern());
  }

    /**
     * Test get validator name.
     */
    @Test
  public void testGetValidatorName() {
    assertEquals("e-mail",
      ve.getValidatorName());
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
         * The Ve.
         */
        ValidateEmail ve = ValidateEmail.getInstance();

        /**
         * Instantiates a new Testis valid.
         *
         * @param str  the str
         * @param bool the bool
         */
        public TestisValid(String str, Boolean bool) {
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

      return Arrays.asList(new Object[] {"GFHGl.it", false},
        new Object[] {"ass@rtit", false},
        new Object[] {"sdfs@live.it", true},
        new Object[] {"\0", false},
        new Object[] {"y", false},
        new Object[] {"...@..", false},
        new Object[] {"asds3@4...23", false},
        new Object[] {"@SdfsdSDFS.D", false},
        new Object[] {"aas@l.l00", true},
        new Object[] {"313@5465.456", true},
        new Object[] {"4-@-$$", false},
        new Object[] {"sad@4-.00", true});
    }

        /**
         * Test is valid.
         */
        @Test
    public void testIsValid() {
      assertEquals(ve.isValid(str), bool);
    }

  }
}