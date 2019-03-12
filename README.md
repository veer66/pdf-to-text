# pdf-to-text
A PDFBox wrapper in Clojure for extracting text from PDF

## Example

### deps.edn

```
{:deps {org.clojure/clojure {:mvn/version "1.10.0"}
        veer66/pdf-to-text {:git/url "https://github.com/veer66/pdf-to-text"
                            :sha "3013e480b5c5bc04bc1dc8b6a7ebaf35b1f63df8"}}}
```

### ext-pdf.clj

```
(require '[pdf-to-text :refer [pdf-to-text]]
         '[clojure.java.io :refer [as-file]])
(-> (as-file "/path/to/my-file.pdf")
    pdf-to-text
    println)
```

### Run

```
clj ext-pdf.clj
```

## Reference
* https://radixcode.com/pdfbox-example-code-how-to-extract-text-from-pdf-file-with-java
