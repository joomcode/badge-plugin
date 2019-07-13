package com.jenkinsci.plugins.buildDisplayHtml.action;

import hudson.model.Action;
import org.jenkinsci.plugins.scriptsecurity.sandbox.whitelists.Whitelisted;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

import java.io.Serializable;
import java.util.logging.Logger;


@ExportedBean(defaultVisibility = 2)
public class BuildDisplayHtmlAction implements Action, Serializable {
  private static final long serialVersionUID = 1L;
  private static final Logger LOGGER = Logger.getLogger(BuildDisplayHtmlAction.class.getName());

  private String summaryHtml = "";

  public BuildDisplayHtmlAction(String summaryHtml) {
    this.summaryHtml = summaryHtml;
  }

  /* Action methods */
  public String getUrlName() {
    return "";
  }

  public String getDisplayName() {
    return "";
  }

  public String getIconFileName() {
    return null;
  }

  @Exported
  public String getSummaryHtml() {
      return summaryHtml;
  }
}
