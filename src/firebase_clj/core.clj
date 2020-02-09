(ns clj-firebase.core
  ; (require '[etaoin.api :refer :all])
  (:require [clj-http.client :as client]
            [cheshire.core :as json]
            [etaoin.keys :as k]
            [etaoin.api :refer :all]))



(def driver (firefox)) ;; here, a Firefox window should appear

(defn run [] 

  (doto driver 
      (go "https://www.meualelo.com.br/")
      (wait-visible [{:tag :input :name :cpf }])
      (fill {:tag :input :name :cpf } "95564268253")
      (fill {:tag :input :name :pass } "Emw83XEjZN")
      (click {:tag :input :type :submit})
      (wait-visible [{:tag :button :class "button button-empty button-clear col-12" }])
      (click {:tag :button :class "button button-empty button-clear col-12"})
    )



  (def basic-url "https://firestore.googleapis.com/v1/projects/yanb-ab5c1/databases/(default)/documents/"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn call 
  [x]
  (client/get x
              {:as :json}))

(defn paths [x] (str basic-url x))

(defn get-documents [p] (map #(:fields %)  (:documents (:body (call (paths p)
                                                                    )))))

;(defn get-document-by-id )

