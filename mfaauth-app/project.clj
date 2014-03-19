(defproject mfaauth/mfaauth-app "0.0.1-SNAPSHOT"
  :description "application to generate mfa authentication codes"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [mfaauth/mfaauth-lib "0.0.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 [org.clojure/data.json "0.2.3"]
                 [log4j/log4j "1.2.16"]
                 [http-kit "2.1.12"]
                 [compojure "1.1.5"]]
  :main mfaauth-app.app
  :manifest {"Manifest-Version" "1.0"
             "Main-Class" "mfaauth_app.app"})
