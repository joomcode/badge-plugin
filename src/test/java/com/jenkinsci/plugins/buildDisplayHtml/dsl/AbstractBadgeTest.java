package com.jenkinsci.plugins.buildDisplayHtml.dsl;

import org.junit.ClassRule;
import org.junit.Rule;
import org.jvnet.hudson.test.BuildWatcher;
import org.jvnet.hudson.test.JenkinsRule;

public abstract class AbstractBadgeTest {

  @ClassRule
  public static BuildWatcher buildWatcher = new BuildWatcher();
  @Rule
  public JenkinsRule r = new JenkinsRule();

}
