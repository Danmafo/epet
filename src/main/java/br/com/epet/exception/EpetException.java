package br.com.epet.exception;

public class EpetException extends ApiException {

    private static final long serialVersionUID = 1L;

    public EpetException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public EpetException(Exception e) {
        super(e);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
