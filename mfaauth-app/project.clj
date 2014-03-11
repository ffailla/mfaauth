(defproject mfaauth/mfaauth-app "0.0.1-SNAPSHOT"
  :description "application to generate mfa authentication codes"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [mfaauth/mfaauth-lib "0.0.1"]]
  :main mfaauth-app.app
  :manifest {"Manifest-Version" "1.0"
             "Main-Class" "mfaauth_app.app"})
