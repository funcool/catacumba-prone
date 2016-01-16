(ns catacumba.plugins.prone
  "A prone exception reporting middleware integration."
  (:require [prone.debug :as pdbg]
            [prone.middleware :as pmdw]
            [catacumba.core :as ct]
            [catacumba.http :as http]
            [catacumba.helpers :as hp]
            [catacumba.handlers.misc :as misc]
            [catacumba.impl.routing :as rt]
            [catacumba.impl.handlers :as hs])
  (:import ratpack.handling.Chain))

(defn- prone-assets
  [ctx]
  (if-let [asset (pmdw/asset-url->contents (:path ctx))]
    (let [response {:body asset :status 200
                    :headers {"Cache-Control" "max-age=315360000"}}]
      (if (.endsWith (:path ctx) ".css")
        (assoc-in response [:headers :content-type] "text/css")
        response))
    (ct/delegate)))

(defn- prone-errors
  [context error namespaces]
  (binding [pdbg/*debug-data* (atom [])]
    (pmdw/exceptions-response context error namespaces)))

(defn handler
  [{:keys [namespaces]}]
  (fn [^Chain chain]
    (-> chain
        (.all (hs/adapter prone-assets))
        (rt/attach-server-error-handler #(prone-errors %1 %2 namespaces)))))

