(ns mfaauth-app.app
  (:require [org.httpkit.server :as hs]
            [compojure.route :as croute]
            [compojure.handler :as chandler] ; form, query params decode; cookie; session, etc
            [compojure.core :as ccore]
            [clojure.tools.logging :as logger]
            [clojure.data.json :as json])
  (:import [mfaauth Authenticator])
  (:gen-class))

(defn get-code
  [key]
  (Authenticator/getCheckCode key))

(def root (str (System/getProperty "user.dir") "/public"))

(ccore/defroutes all-routes
  (ccore/GET "/api/mfacode/:key" [key]
              {:status 200
               :headers {"Content-Type" "application/json"
                         "Access-Control-Allow-Origin:" "*"}
               :body (json/write-str {:mfacode (get-code key)})})
  (croute/files "/static/" {:root root})
  (croute/not-found "<p>Page not Found</p>"))

(defn run-web
  []
  (hs/run-server (chandler/site #'all-routes) {:port 8189}))

(defn run-console
  [key]
  (println "generating mfa codes for: " key)
  (loop []
   (println (get-code key))
    (Thread/sleep 30000)
    (recur)))

(defn -main
  [& args]
  (if args
    (run-console (first args))
    (run-web)))

(comment

  (get-code "7777777777777777")
  
  )
