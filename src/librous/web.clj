(ns librous.web
  (:use compojure.core
        [librous.db :as db]
        [ring.adapter.jetty :as ring])
  (:require [ring.middleware.json :as middleware]
            [compojure.handler :as handler]
            [librous.router :as router]))

(defn init [] (db/connect))

(def app
  (-> (handler/api router/app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))

(defn -main []
  (init)
  (let [port(Integer/parseInt (or (System/getenv "PORT") "5000"))]
    (run-jetty #'app {:port port :join? false})))
