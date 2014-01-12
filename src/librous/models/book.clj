(ns librous.models.book
  (:require monger.json
            [monger.collection :as mc]))

(defn create [params]
  (mc/insert "books" params))

(defn all []
  (mc/find-maps "books"))

(defn count_all []
  (mc/count "books"))
