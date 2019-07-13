package com.jenkinsci.plugins.buildDisplayHtml.dsl;

import com.jenkinsci.plugins.buildDisplayHtml.action.BuildDisplayHtmlAction;
import com.jenkinsci.plugins.buildDisplayHtml.annotations.OptionalParam;
import com.jenkinsci.plugins.buildDisplayHtml.annotations.Param;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import hudson.Extension;
import hudson.model.Run;
import org.apache.commons.lang.StringUtils;
import org.jenkinsci.plugins.workflow.steps.Step;
import org.jenkinsci.plugins.workflow.steps.StepContext;
import org.jenkinsci.plugins.workflow.steps.StepExecution;
import org.jenkinsci.plugins.workflow.steps.SynchronousStepExecution;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

/**
 * Create a summary text.
 */
public class BuildDisplayHtmlStep extends Step {

  private String summaryHtml;

  @DataBoundConstructor
  public BuildDisplayHtmlStep(@Param(
          name = "summaryHtml",
          description = "A html which will be appended to build summary page"
  ) String summaryHtml) {
    this.summaryHtml = summaryHtml;
  }

  public String getSummaryHtml() {
    return summaryHtml;
  }

  @DataBoundSetter
  public void setSummaryHtml(String summaryHtml) {
    this.summaryHtml = summaryHtml;
  }

  @Override
  public StepExecution start(StepContext context) {
    return new Execution(summaryHtml, context);
  }

  @Extension
  public static class DescriptorImpl extends AbstractTaskListenerDescriptor {

    @Override
    public String getFunctionName() {
      return "buildDisplayHtml";
    }

    @Override
    public String getDisplayName() {
      return "Add custom html to build summary page";
    }

  }

  public static class Execution extends SynchronousStepExecution<BuildDisplayHtmlAction> {

    @SuppressFBWarnings(value = "SE_TRANSIENT_FIELD_NOT_RESTORED", justification = "Only used when starting.")
    private transient final String summaryHtml;

    Execution(String summaryHtml, StepContext context) {
      super(context);
      this.summaryHtml = summaryHtml;
    }

    @Override
    protected BuildDisplayHtmlAction run() throws Exception {
      BuildDisplayHtmlAction action = new BuildDisplayHtmlAction(summaryHtml);
      getContext().get(Run.class).addAction(action);
      return action;
    }

    private static final long serialVersionUID = 1L;

  }

}