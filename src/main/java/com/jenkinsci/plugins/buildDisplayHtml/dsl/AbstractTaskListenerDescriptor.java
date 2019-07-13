package com.jenkinsci.plugins.buildDisplayHtml.dsl;

import hudson.model.TaskListener;
import org.jenkinsci.plugins.workflow.steps.StepDescriptor;

import java.util.HashSet;
import java.util.Set;

abstract class AbstractTaskListenerDescriptor extends StepDescriptor {

  @Override
  public Set<Class<?>> getRequiredContext() {
    Set<Class<?>> set = new HashSet<>();
    set.add(TaskListener.class);
    return set;
  }
}
