(ns bashpipe.core
  (:require [clojure.java.io :as io]))


(defn run [^String cmd]
  (let [string-array ^"[Ljava.lang.String;" (into-array String cmd)
        builder (ProcessBuilder. string-array)
        process (.start builder)]
    {:out (.getInputStream process)
     :in (.getOutputStream process)
     :err (.getErrorStream process)
     :process process}))


(def bash (run ["bash"]))


(defn put! [command]
  (let [stream ^java.io.OutputStream (:in bash)]
    (io/copy (java.io.StringReader. (str command "\n"))
             stream)
    (.flush stream)))


(defn get! []
  (let [stream ^java.io.InputStream (:out bash)
        avail (.available stream)
        bytes (byte-array avail)]
    (.read stream bytes)
    (String. bytes)))
