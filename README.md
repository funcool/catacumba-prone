# catacumba-prone #

[![Clojars Project](http://clojars.org/funcool/catacumba-prone/latest-version.svg)](http://clojars.org/funcool/catacumba-prone)


## Introduction ##

A [prone][1] (error reporting middleware) integration
for catacumba.

[Prone][1] is a exception reporting middleware for ring based applications that
show a beautiful, navegable and human readable stacktraces when an exception is
throwed in your application. It is not directly compatible with catacumba but
here is a integration that allows you use almost all features that it exposes.


## Quick Start ##

For use it on your application, add the appropriate dependency:

```clojure
[funcool/catacumba-prone "0.4.0"]
```

Later, add the prone handler to you route chain:

```clojure
(ns myappns.routes
  (:require [catacumba.core :as ct]
            [catacumba.plugins.prone :as prone]))

(def app
  (ct/routes [[:setup (prone/handler {:namespaces ["myappns"]})]
              ;; your handlers here
              ]))
```

Now, if an exception is happens in your application, the prone middleware will
capture it and showed in a beautiful manner.


## Contributing & License ##

The same as [catacumba][2].


[1]: https://github.com/magnars/prone
[2]: https://funcool.github.io/catacumba/latest/#developers-guide
