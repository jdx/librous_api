(defproject librous "1.0.0-SNAPSHOT"
  :description "Librous api"
  :url "http://api.librous.com"
  :main librous.web
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [ring/ring-json "0.2.0"]
                 [compojure "1.1.6"]
                 [cheshire "5.3.1"]
                 [environ "0.4.0"]
                 [com.novemberain/monger "1.7.0"]]
  :min-lein-version "2.0.0"
  :plugins [[lein-ring "0.8.10"]
            [lein-environ "0.4.0"]]
  :ring {:handler librous.web/app :init librous.web/init}
  :profiles {:production {:env {:production true}}
             :test {:dependencies [[ring-mock "0.1.5"]]}})
