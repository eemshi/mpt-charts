(ns mpt-charts.stats)

(def risk-free-rate 0) ;; omitted

(defn average [nums]
  (/ (apply + nums) (count nums)))

(defn standard-deviation-p [list]
  (let [mean (average list)
        list-value-minus-mean-squared (map #(* (- % mean) (- % mean)) list)
        sum (apply + list-value-minus-mean-squared)
        variance (/ sum (count list))]
    (.sqrt js/Math variance)))

(defn covariance [list-x list-y]
  (let [mean-x (average list-x)
        mean-y (average list-y)]
    (/ (->> (map (fn [x y] (* (- x mean-x) (- y mean-y))) list-x list-y)
            (apply +))
       (count list-x))))