(defproject test-fn-fx "0.1.0-SNAPSHOT"
  :description "A test project for fn-fx"
  :url "http://example.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 ^{:voom {:repo "https://github.com/halgari/fn-fx" :branch "master"}}
                 [org.clojure/clojure "1.8.0"]
                 [org.fxmisc.richtext/richtextfx "0.8.1"]
                 ]
  :main ^:skip-aot test-fn-fx.core
  :target-path "target/%s"
  :java-source-paths ["src/java"]
  :profiles {:uberjar {:aot :all}})
