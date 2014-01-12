(ns librous.db-test
  (:use clojure.test)
  (:require [librous.db :as db]))

(defn db-fixture [f]
  (db/test-connect)
  (db/test-clear)
  (f))
