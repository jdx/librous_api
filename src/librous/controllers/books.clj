(ns librous.controllers.books
  (:use ring.util.response)
  (:require [librous.models.book :as book]))

(defn index []
  {"books" (book/all) "count" (book/count_all)})

(defn create [params]
  (book/create (params "book"))
  "Created")
