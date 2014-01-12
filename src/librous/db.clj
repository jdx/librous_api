(ns librous.db
  (:use environ.core)
  (:require [monger.core :as mg]
            [monger.db :as md]))

(defn connect []
  (mg/connect-via-uri! (or (System/getenv "MONGOLAB_URI") "mongodb://127.0.0.1/librous")))

(defn test-db [] (mg/get-db "librous_test"))

(defn test-connect []
  (mg/connect!)
  (mg/set-db! (test-db)))

(defn test-clear [] (md/drop-db (test-db)))
