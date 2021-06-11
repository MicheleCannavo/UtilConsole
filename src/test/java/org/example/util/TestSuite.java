package org.example.util;

import org.example.util.console.TestInput;
import org.example.util.console.TestOutput;
import org.example.util.validator.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  TestValidateName.class,     TestValidateNameProject.class,
  TestValidateGeneric.class,  TestValidateEmail.class,
  TestValidatePassword.class, TestValidateNumber.class,
  TestOutput.class,           TestValidateVersion.class,
  TestInput.class
})
class JunitTestSuite {
}