# moria

ClojureScript wrapper for [mithril.js](https://github.com/lhorie/mithril.js)

[![Clojars Project](https://img.shields.io/clojars/v/moria.svg)](https://clojars.org/moria)

  * Mithril [website](http://mithril.js.org/) (documentation, examples etc.)
  * Mithril [blog](http://lhorie.github.io/mithril-blog)
  * Mithril [mailing list](https://groups.google.com/forum/#!forum/mithriljs)

## What is Mithril? (from the mithril.js README)

Mithril is a client-side MVC framework - a tool to organize code in a way that is easy to think about and to maintain.

## Light-weight

  * Only 7.8 kB gzipped, no dependencies
  * Small API, small learning curve

## Robust

  * Safe-by-default templates
  * Hierarchical MVC via components

## Fast

  * Virtual DOM diffing and compilable templates
  * Intelligent auto-redrawing system
 
These attributes combined with ClojureScript make Moria a fantastic choice for writing a ClojureScript frontend.

## Todo

  * as of today (2016-06-14) Moria is already a minor version behind Mithril (bump cljsjs.mithril version as well)
  * documentation and examples
  * incorporate spec for validation for required / optional keys
  * currently a one-to-one copy of Mithril in ClojureScript, some patterns such as `m.prop` and `m.promise` are improved or made obsolete by `core.async` or immutability
    * improve this with some idiomatic CLJS patterns
 
Thank you [Leo Horie](https://github.com/lhorie)
