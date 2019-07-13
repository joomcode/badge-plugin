package com.jenkinsci.plugins.buildDisplayHtml;

import hudson.Extension;
import jenkins.model.GlobalConfiguration;

@Extension
public class BuildDisplayHtmlPlugin extends GlobalConfiguration {

  /** @return the singleton instance */
  public static BuildDisplayHtmlPlugin get() {
    return GlobalConfiguration.all().get(BuildDisplayHtmlPlugin.class);
  }

  public BuildDisplayHtmlPlugin() {
    // When Jenkins is restarted, load any saved configuration from disk.
    load();
  }

}
