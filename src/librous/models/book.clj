(ns librous.models.book
  (:use librous.db)
  (:require monger.json
            [monger.collection :as mc]))

(defn create [params]
  (mc/insert "books" params))

(defn all []
  (mc/find-maps "books"))
