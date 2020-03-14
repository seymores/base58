(ns base58.core
  "Base58 is a binary-to-text encoding algorithm that’s designed to encode a 
   blob of arbitrary binary data into human readable text, much like the more 
   well known Base64 algorithm.")

(def ^:const alphabet "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz")

(defn- decode_unsigned
  [s]
  (cond 
    (number? s) s
    (= s "") 0
    :else (bigint (.getBytes s))))

(defn encode
  "Encode s to base58 text value."
  [s]
  (loop [data (decode_unsigned s)
         hash ""]
    (let [div (quot data 58)
          result (str (nth alphabet (rem data 58)) hash)]
      (if (zero? div)
        result
        (recur div result)))))
