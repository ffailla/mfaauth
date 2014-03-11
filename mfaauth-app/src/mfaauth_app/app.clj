(ns mfaauth-app.app
  (:import [mfaauth Authenticator])
  (:gen-class))

(defn get-code
  [key]
  (Authenticator/getCheckCode key))

(defn -main
  [key]
  (println "generating mfa codes for: " key)
  (loop []
    (println (get-code key))
    (Thread/sleep 30000)
    (recur)))

(comment

  (get-code "7777777777777777")
  
  )
