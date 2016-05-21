(defproject prime-table "0.1.0-SNAPSHOT"
  :description "Prime number multiplication table engine."
  :url "http://github.com/nez/prime-table"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [net.mikera/core.matrix "0.52.0"]]
  :main prime-table.core
  :repl-options {:init-ns prime-table.core})
