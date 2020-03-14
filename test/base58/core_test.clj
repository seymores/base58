(ns base58.core-test
  (:require [clojure.test :refer :all]
            [base58.core :as b58]))

(deftest encode
  (testing "Enoding string to base58 value"
    (is (= (b58/encode "hello") "Cn8eVZg"))))
