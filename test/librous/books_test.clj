(ns librous.books-test
  (:use clojure.test
        ring.mock.request
        librous.db-test)
  (:require [cheshire.core :refer :all]
            [librous.controllers.books :as books]))

(deftest creating-book
  (books/create {"book" {"title" "Foobar"}})
  (is (= 1 ((books/index) "count"))))

(use-fixtures :each db-fixture)
