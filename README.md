# pdf-to-text
A PDFBox wrapper in Clojure for extracting text from PDF

## Example

### deps.edn

```edn
{:deps {org.clojure/clojure {:mvn/version "1.10.0"}
        veer66/pdf-to-text {:git/url "https://github.com/veer66/pdf-to-text"
                            :sha "2ddad6936d7820ad82e877fa7fd6ec891f0412e3"}}}
```

### ext-pdf.clj

```clojure
(require '[pdf-to-text :refer [pdf-to-text]]
         '[clojure.java.io :refer [as-file]])
(-> (as-file "/path/to/my-file.pdf")
    pdf-to-text
    println)
```

### Run

```sh
clj ext-pdf.clj
```

## Reference
* https://radixcode.com/pdfbox-example-code-how-to-extract-text-from-pdf-file-with-java
