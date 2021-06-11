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

public class TestValidateEmail {
  ValidateEmail ve;

  @Before
  public void preCondition(){
    ve = ValidateEmail.getInstance();
  }

  @Test
  public void testGetDescriptorRulesValidation() {
    assertEquals("Indirizzo Valido",
      ve.validationRules);
  }

  @Test
  public void testGetPattern() {
    assertEquals("^[a-zA-Z0-9\\.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]{2,4}$",
      ve.getPattern());
  }

  @Test
  public void testGetValidatorName() {
    assertEquals("e-mail",
      ve.getValidatorName());
  }

  @RunWith(Parameterized.class)
  public static class TestisValid {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String str;
    private final boolean bool;
    ValidateEmail ve = ValidateEmail.getInstance();

    public TestisValid(String str, Boolean bool) {
      this.str = str;
      this.bool = bool;
    }

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

    @Test
    public void testIsValid() {
      assertEquals(ve.isValid(str), bool);
    }

    @Test
    public void TestRequest() {
      systemInMock.provideLines(str);
      assertEquals(bool ? str : null, ve.request());
    }

  }
}