(ns test-fn-fx.core
  (:require [fn-fx.fx-dom :as dom]
            [fn-fx.diff :refer [component defui render should-update?]]
            [fn-fx.controls :as ui]))

(import 'org.fxmisc.richtext.CodeArea)

(defmacro ca [& {:as props}]
  (fn-fx.render-core/component-impl :org.fxmisc.richtext.CodeArea props #{}))

(comment 
  
 (let [prop "minHeight"] (fn-fx.util/kabob->class (clojure.string/replace (name prop) "?" "")))

 (let [prop "minHeight"] (str "set" (fn-fx.util/kabob->class (clojure.string/replace (name prop) "?" ""))))

)

;; The main login window component, notice the authed? parameter, this defines a function
;; we can use to construct these ui components, named "login-form"
(defui LoginWindow
       (render [this {:keys [authed?]}]
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
                              :minHeight 300
                              :editable true
                              )
                            (ui/text-flow
                              :children
                              [(ui/text
                                 :text "Welcome"
                                 :font (ui/font
                                         :family "Tahoma"
                                         :weight :normal
                                         :size 20))
                               (ui/text
                                 :text "Motherfucker"
                                 :font (ui/font
                                         :family "Tahoma"
                                         :weight :normal
                                         :size 20))])
                            ])))

;; Wrap our login form in a stage/scene, and create a "stage" function
(defui Stage
       (render [this args]
               (ui/stage
                 :title "JavaFX Welcome"
                 :shown true
                 :scene (ui/scene
                          :root (login-window args)))))

(defn -main []
  (let [;; Data State holds the business logic of our app
        data-state (atom {:authed? false})

        ;; handler-fn handles events from the ui and updates the data state
        handler-fn (fn [{:keys [event] :as all-data}]
                     (println "UI Event" event all-data)
                     )

        ;; ui-state holds the most recent state of the ui
        ui-state (agent (dom/app (stage @data-state) handler-fn))]

    ;; Every time the data-state changes, queue up an update of the UI
    ))
