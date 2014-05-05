(defproject bashpipe "0.1.0-SNAPSHOT"
  :description "Library maintaining a long-lived bash shell in order
  not to spawn a process everytime you shell out."
  :url "http://github.com/jsab/bashpipe"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :global-vars {*warn-on-reflection* true
                *assert* false})
