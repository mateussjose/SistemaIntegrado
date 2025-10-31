package model.exception;


public class AnaliseException extends Exception {
    public AnaliseException(String message) { super(message); }
    public AnaliseException(String message, Throwable cause) { super(message, cause); }
}