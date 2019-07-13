package com.jenkinsci.plugins.buildDisplayHtml.dsl;

import com.jenkinsci.plugins.buildDisplayHtml.action.BuildDisplayHtmlAction;
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.jenkinsci.plugins.workflow.job.WorkflowRun;
import org.junit.Test;

import java.util.List;

import static java.util.UUID.randomUUID;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BuildDisplayHtmlStepTest extends AbstractBadgeTest {

  @Test
  public void createSummary_plain() throws Exception {
    String text = randomUUID().toString();
    BuildDisplayHtmlAction action = createSummary("'" + text + "'");
    assertEquals(text, action.getSummaryHtml());
  }

  @Test
  public void createSummary_html_unescaped() throws Exception {
    String text = randomUUID().toString();
    BuildDisplayHtmlAction action = createSummary("'<li>" + text + "</li>'");
    assertEquals("<li>" + text + "</li>", action.getSummaryHtml());
  }

  private BuildDisplayHtmlAction createSummary(String html) throws Exception {
    WorkflowJob p = r.jenkins.createProject(WorkflowJob.class, "p");
    p.setDefinition(new CpsFlowDefinition(
            String.format("buildDisplayHtml(%s)", html),
            true
    ));
    WorkflowRun b = r.assertBuildStatusSuccess(p.scheduleBuild2(0));
    List<BuildDisplayHtmlAction> summaryActions = b.getActions(BuildDisplayHtmlAction.class);
    assertEquals(1, summaryActions.size());

    BuildDisplayHtmlAction action = summaryActions.get(0);
    return action;
  }

  @Test
  public void createSummary_with_text() throws Exception {
    String text = randomUUID().toString();

    WorkflowJob p = r.jenkins.createProject(WorkflowJob.class, "p");
    p.setDefinition(new CpsFlowDefinition("buildDisplayHtml(summaryHtml: \"" + text + "\")", true));
    WorkflowRun b = r.assertBuildStatusSuccess(p.scheduleBuild2(0));
    List<BuildDisplayHtmlAction> summaryActions = b.getActions(BuildDisplayHtmlAction.class);
    assertEquals(1, summaryActions.size());

    BuildDisplayHtmlAction action = summaryActions.get(0);
    assertEquals(text, action.getSummaryHtml());
  }
}