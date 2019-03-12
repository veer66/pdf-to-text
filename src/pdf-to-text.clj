(ns pdf-to-text
  (:import org.apache.pdfbox.io.RandomAccessFile
           org.apache.pdfbox.pdfparser.PDFParser
           org.apache.pdfbox.pdmodel.PDDocument
           org.apache.pdfbox.text.PDFTextStripper))

(defn pdf-to-text
  [f]
  (with-open [r (RandomAccessFile. f "r")]
    (let [parser (PDFParser. r)          
          text-stripper (PDFTextStripper.)]
      (with-open [cos-doc (.getDocument parser)
                  pd-doc (PDDocument. cos-doc)]
        (.parse parser)
        (doto text-stripper
          (.setStartPage 0)
          (.setStartPage (.getNumberOfPages pd-doc)))
        (.getText text-stripper pd-doc)))))

;; Tutorial for Java
;; https://radixcode.com/pdfbox-example-code-how-to-extract-text-from-pdf-file-with-java

