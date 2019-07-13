package com.jenkinsci.plugins.buildDisplayHtml.action;

import hudson.model.Action;
import hudson.model.BuildBadgeAction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassHierarchyTest {

  @Test
  public void badgeSummaryAction() {
    assertTrue(Action.class.isAssignableFrom(BuildDisplayHtmlAction.class));
    assertFalse(BuildBadgeAction.class.isAssignableFrom(BuildDisplayHtmlAction.class));
  }
}