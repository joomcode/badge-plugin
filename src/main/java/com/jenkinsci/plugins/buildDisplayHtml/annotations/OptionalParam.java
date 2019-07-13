package com.jenkinsci.plugins.buildDisplayHtml.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An optional badge param
 */

@Documented
@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface OptionalParam {

  /**
   * @return description for this param
   */
  String description();
}
