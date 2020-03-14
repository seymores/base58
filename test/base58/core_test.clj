(ns base58.core-test
  (:require [clojure.test :refer :all]
            [base58.core :as b58]))

(deftest encode-string
  (testing "Encoding string to base58 value"
    (is (= (b58/encode "hello") "Cn8eVZg"))))

(deftest encode-number
  (testing "Encoding number to base58 value"
    (is (= (b58/encode 12345) "4fr"))))