(defproject funcool/catacumba-prone "0.2.1"
  :description "A prone integration for catacumba"
  :url "http://github.com/funcool/catacumba-prone"
  :license {:name "BSD (2-Clause)"
            :url "http://opensource.org/licenses/BSD-2-Clause"}
  :source-paths ["src"]
  :jar-exclusions [#"\.swp|\.swo|bench\.clj|user\.clj"]
  :javac-options ["-target" "1.8" "-source" "1.8"
                  "-Xlint:-options" "-Xlint:unchecked"]
  :plugins [[lein-ancient "0.6.10"]]
  :dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]
                 [funcool/catacumba "0.16.0" :scope "provided"]
                 [prone "1.1.1"]])
