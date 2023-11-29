package org.ict.lookism.exception;

public class UnauthorizedException extends RuntimeException {
    private static final long serialVersionUID = -2238030302650813813L;

    public UnauthorizedException() {
        super("Invalid token");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
