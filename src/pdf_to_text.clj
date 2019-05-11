(ns pdf-to-text
  (:require [clojure.string :refer [join]])
  (:import org.apache.pdfbox.io.RandomAccessFile
           org.apache.pdfbox.pdfparser.PDFParser
           org.apache.pdfbox.pdmodel.PDDocument
           org.apache.pdfbox.text.PDFTextStripper)
  (:gen-class))

(defn extract-from-page [pd-doc text-stripper page]
  (doto text-stripper
    (.setStartPage page)
    (.setEndPage page))
  (.getText text-stripper pd-doc))

(defn pdf-to-text
  [f]
  (with-open [r (RandomAccessFile. f "r")]
    (let [parser (PDFParser. r)          
          text-stripper (PDFTextStripper.)]
      (with-open [cos-doc (.getDocument parser)
                  pd-doc (PDDocument. cos-doc)]
        (.parse parser)
        (let [pages (range (.getNumberOfPages pd-doc))
              texts (map #(extract-from-page pd-doc text-stripper (inc %)) pages)]
          (join "\t" texts))))))

(defn -main [& args]
  (if (not= 1 (count args))
    (do
      (println "Usage: clj -m pdf-to-text <pdf file>")
      (System/exit 1))
    (println (pdf-to-text (clojure.java.io/as-file (first args))))))
