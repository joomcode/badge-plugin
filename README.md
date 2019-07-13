jenkins-badge-plugin
=========================

Jenkins plugin to add badges and build summary entries from a pipeline.

This plugin was forked from the [Groovy Postbuild Plugin](https://github.com/jenkinsci/groovy-postbuild-plugin) which will in future use the API from this plugin.

## createSummary

Puts a badge with a short text

![alt text](src/doc/summary.png "Summary")


```groovy

// creates an entry in the build summary page and returns a summary object corresponding to this entry.

// buildDisplayHtml
// ------------------------------------------

/**
 * minimal params
 * 
 * summaryHtml: A html which will be appended to build summary page
 */
buildDisplayHtml(summaryHtml: <summaryHtml>)

/**
 * all params
 * 
 * summaryHtml: A html which will be appended to build summary page
 * summaryHtml: (optional) A html which will be appended to build summary page
 */
buildDisplayHtml(summaryHtml: <summaryHtml>, summaryHtml: <summaryHtml>)


def summary = createSummary()
summary.appendText(htmlText)
```

