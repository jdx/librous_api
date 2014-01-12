(ns librous.router
  (:use compojure.core
        ring.util.response)
  (:require [librous.controllers.books :as books]))

(defroutes app-routes
  (context "/books" [] (defroutes _
    (GET  "/" [] (response (books/index)))
    (POST "/" {body :body} (response (books/create body)))))
  (GET  "/" [] (response {:version "1.0"})))
