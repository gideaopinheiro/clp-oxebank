(ns investment.model)

(def cdb
  {:acronym "cdb"
   :asset-name "certificado de deposito bancario"
   :minimum-investment 10.00
   :monthly 0.007})

(def lci {:acronym "lci", :asset-name "letra de credito imobiliario", :minimum-investment 1.00, :monthly 0.009})

(def lca {:acronym "lca", :asset-name "letra de credito do agronegocio", :minimum-investment 1.00, :monthly 0.006})
