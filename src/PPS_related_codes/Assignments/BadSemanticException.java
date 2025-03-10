package PPS_related_codes.Assignments;

//SUJITH KUMAR KUMARVEL 40281567
// COMP6481 Assignment # Due Date
//Assignment-2
// Due 24 March
class BookSemanticException extends Exception {
    private String record;
    private String fileName;

    public BookSemanticException(String message, String record, String fileName) {
        super(message);
        this.record = record;
        this.fileName = fileName;
    }

    public String getRecord() {
        return record;
    }

    public String getFileName() {
        return fileName;
    }
}

class BadPriceException extends BookSemanticException {
    public BadPriceException(String message, String record, String fileName) {
        super(message, record, fileName);
    }
}

class BadYearException extends BookSemanticException {
    public BadYearException(String message, String record, String fileName) {
        super(message, record, fileName);
    }
}

class BadIsbn10Exception extends BookSemanticException {
    public BadIsbn10Exception(String message, String record, String fileName) {
        super(message, record, fileName);
    }
}

class BadIsbn13Exception extends BookSemanticException {
    public BadIsbn13Exception(String message, String record, String fileName) {
        super(message, record, fileName);
    }
}
