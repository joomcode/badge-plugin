jenkins-build-display-html-plugin
=========================

Jenkins plugin to add build summary entries from a pipeline.

This plugin was initially forked from the [jenkins-badge-plugin](https://github.com/jenkinsci/badge-plugin) which had been forked from [Groovy Postbuild Plugin](https://github.com/jenkinsci/groovy-postbuild-plugin).

## buildDisplayHtml

Puts a badge with a short text

![alt text](src/doc/summary.png "Summary")


```groovy

// creates an entry in the build summary page and returns a summary object corresponding to this entry.

// buildDisplayHtml
// ------------------------------------------

/**
 * params
 * 
 * summaryHtml: A html which will be appended to build summary page
 */
buildDisplayHtml(summaryHtml: <summaryHtml>)



buildDisplayHtml("<p>A paragraph</p>")
buildDisplayHtml(summaryHtml: '<img src=... />')
buildDisplayHtml("""simple text that is very important to see on the build summary page""")
```

