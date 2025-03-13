package com.grazielleanaia.agendadortarefas.infrastructure.exceptions;

import org.springframework.security.core.AuthenticationException;

public class UnathorizedException extends AuthenticationException {
    public UnathorizedException(String mensagem) {
        super(mensagem);
    }

    public UnathorizedException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}
