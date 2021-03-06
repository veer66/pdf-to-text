# pdf-to-text
A PDFBox wrapper in Clojure for extracting text from PDF

## Usage as a library

### deps.edn

```edn
{:deps {org.clojure/clojure {:mvn/version "1.10.0"}
        veer66/pdf-to-text {:git/url "https://github.com/veer66/pdf-to-text"
                            :sha "7e20b104c7c8d8da1032e609384edb5cee3b6dff"}}}
```

### ext-pdf.clj

```clojure
(require '[pdf-to-text :refer [pdf-to-text]]
         '[clojure.java.io :refer [as-file]])
(-> (as-file "/path/to/my-file.pdf")
    pdf-to-text
    println)
```

## Usage as a command line interface

```
clj -m pdf-to-text <pdf file>
```

## Reference
* https://radixcode.com/pdfbox-example-code-how-to-extract-text-from-pdf-file-with-java
