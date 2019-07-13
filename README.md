jenkins-badge-plugin
=========================

Jenkins plugin to add badges and build summary entries from a pipeline.

This plugin was forked from the [Groovy Postbuild Plugin](https://github.com/jenkinsci/groovy-postbuild-plugin) which will in future use the API from this plugin.

## createSummary

Puts a badge with a short text

![alt text](src/doc/summary.png "Summary")


```groovy

// creates an entry in the build summary page and returns a summary object corresponding to this entry.

// createSummary
// ------------------------------------------

/**
 * minimal params
 * 
 */
createSummary()

/**
 * all params
 * 
 * id: (optional) The id for this badge. This id can be used to selectively delete badges.
 * text: (optional) The title text for this summary
 */
createSummary(id: <id>, text: <text>)


def summary = createSummary()
summary.appendText(text, escapeHtml)
summary.appendText(text, escapeHtml, bold, italic, color)
```

