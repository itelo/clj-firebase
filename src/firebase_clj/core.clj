(ns clj-firebase.core

(:require [
           clj-http.client :as client]
          [cheshire.core :as json]
))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn call 
 [x]
  (client/get x
   {:as :json}))


