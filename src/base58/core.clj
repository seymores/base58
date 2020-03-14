(ns base58.core)

(def ^:const alphabet "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz")

(defn- decode_unsigned
  [s]
  (cond 
    (number? s) s
    (= s "") 0
    :else (bigint (.getBytes s))))

(defn encode
  [s]
  (loop [data (decode_unsigned s)
         hash ""]
    (let [div (quot data 58)
          result (str (nth alphabet (rem data 58)) hash)]
      (if (zero? div)
        result
        (recur div result)))))
