(ns librous.web
  (:use [compojure.core :only (defroutes GET)]
        [ring.adapter.jetty :as ring]
        [ring.util.response])
  (:require [ring.middleware.json :as middleware]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [clojure.java.io :as io]
            [librous.db]))

(defroutes routes
  (GET "/" [] (response {:foo "bar"})))

(def app
  (-> (handler/api routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))

(defn -main []
  (let [port(Integer/parseInt (or (System/getenv "PORT") "5000"))]
    (run-jetty #'app {:port port :join? false})))
