(ns librous.db
  (:use [monger.core :only [connect-via-uri!]]))

(defn connect []
  (connect-via-uri! (or (System/getenv "MONGOLAB_URI") "mongodb://127.0.0.1/librous")))

