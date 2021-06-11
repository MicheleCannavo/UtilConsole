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

public class TestValidatePassword {

  ValidatePassword vp;

  @Before
  public void preCondition(){
    vp = ValidatePassword.getInstance();
  }

  @Test
  public void testGetDescriptorRulesValidation() {
    String desc =
      "La password deve contenere:" + System.lineSeparator() +
        "- Una lettera MAIUSCOLA"   + System.lineSeparator() +
        "- Una lettera minuscola"   + System.lineSeparator() +
        "- Un numero"               + System.lineSeparator() +
        "- min 4 caratteri"         + System.lineSeparator() +
        "- max 8 caratteri"         + System.lineSeparator();

    assertEquals(desc, vp.getRulesOfValidation());
  }

  @Test
  public void getPattern() {
    assertEquals("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{4,8}$",
      vp.getPattern());
  }

  @Test
  public void getValidatorName() {
    assertEquals("password",
      vp.getValidatorName());
  }


  @RunWith(Parameterized.class)
  public static class TestisValid {


    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final String str;
    private final boolean bool;
    private ValidatePassword vp = ValidatePassword.getInstance();

    public TestisValid(String str, boolean bool) {
      this.str = str;
      this.bool = bool;
    }

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
        new Object[] {"4assas854",     false});
    }

    @Test
    public void testValidatePassword() {
      System.out.println(str);
      assertEquals(vp.isValid(str), bool);
    }
    @Test
    public void TestRequest() {
      systemInMock.provideLines(str);
      assertEquals(bool ? str : null, vp.request());
    }
  }
}