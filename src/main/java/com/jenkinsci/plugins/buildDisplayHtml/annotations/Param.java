package com.jenkinsci.plugins.buildDisplayHtml.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A required badge param
 */

@Documented
@Retention(RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface Param {

  /**
   * @return the name of this param
   */
  String name();

  /**
   * @return description for this param
   */
  String description();
}
