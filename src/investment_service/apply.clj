(ns investment.apply
  (:require [investment.model :as model]
            [clojure.math.numeric-tower :as math]))


(defn have-enough-balance?
  [client funds]
  (>= (:balance client) funds))


(defn fulfill-rules?
  [asset funds]
  (>= funds (:minimum-investment asset)))


(defn can-apply?
  [client funds asset]
  (and (have-enough-balance? client funds) (fulfill-rules? asset funds)))


(defn apply-funds
  [client funds asset]
  (if (can-apply? client funds asset)
    (println "Applying R$ " funds " from " client "in " asset)
    (println "Can not apply!")))

(defn compound-interest
  [capital flat-rate time-months]
  (* capital (math/expt (+ 1 flat-rate) time-months)))

(defn compount-interest-monthly-deposit
  [capital-month flat-rate time-months]
  (/ (* capital-month (- (math/expt (+ 1 flat-rate) time-months) 1)) flat-rate))

(def client {:name 'gideao', :agency "12345", :account "1231231", :balance 25000})

(apply-funds client 100 model/cdb)
