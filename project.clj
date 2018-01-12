(defproject test-fn-fx "0.1.0-SNAPSHOT"
  :description "A test project for fn-fx"
  :url "http://example.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories {"local" ~(str (.toURI (java.io.File. "/Users/kirillstarikov/.m2/repository")))}
  :dependencies [
                 [org.clojure/clojure "1.9.0"]
                 [org.fxmisc.richtext/richtextfx "0.8.1"]
                 [org.fxmisc.flowless/flowless "0.5.2"]
                 [halgari/fn-fx "0.5.0-SNAPSHOT"]
                 ]
  :main ^:skip-aot test-fn-fx.core
  :target-path "target/%s"
  :java-source-paths ["src/java"]
  :profiles {:uberjar {:aot :all}})
