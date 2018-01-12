(ns test-fn-fx.core
  (:require [fn-fx.fx-dom :as dom]
            [fn-fx.render-core :as render-core]
            [fn-fx.diff :refer [component defui render should-update?]]
            [fn-fx.controls :as ui])
  (:gen-class))

(import 'org.fxmisc.richtext.CodeArea)
(import 'org.fxmisc.flowless.VirtualizedScrollPane)

(defmacro ca [& {:as props}]
  (fn-fx.render-core/component-impl :org.fxmisc.richtext.CodeArea props #{}))

(defmacro vsp [& {:as props}]
  (fn-fx.render-core/component-impl :org.fxmisc.flowless.VirtualizedScrollPane props #{}))

(defui MainWindow
  (render [this args]
          (ui/grid-pane
            :alignment :center
            :hgap 10
            :vgap 10
            :padding (ui/insets
                       :bottom 25
                       :left 25
                       :right 25
                       :top 25)
            :children [(ca
                          :minHeight 400
                          :minWidth 400
                          :editable true
                          )
                        ]
            )))

(defui Stage
       (render [this args]
               (ui/stage
                 :title "Text"
                 :shown true
                 :scene (ui/scene
                          :root (main-window args)))))

(defn -main []
        (def handler-fn (fn [{:keys [event] :as all-data}]
                     (println "UI Event" event all-data)
                     ))

        ;; ui-state holds the most recent state of the ui
        (def ui-state (agent (dom/app (stage [] ) handler-fn)))
  
  )

(comment

        (def handler-fn (fn [{:keys [event] :as all-data}]
                     (println "UI Event" event all-data)
                     ))

        (def ui-state (agent (dom/app (stage [] ) handler-fn)))

      (render-core/get-property (first (reduce (fn [ comp field] ( render-core/get-property comp field )) @(:root @ui-state) [:scene :root :children])) :text )

    )
