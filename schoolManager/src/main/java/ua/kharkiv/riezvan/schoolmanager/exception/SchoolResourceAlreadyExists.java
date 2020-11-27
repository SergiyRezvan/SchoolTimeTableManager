package ua.kharkiv.riezvan.schoolmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class SchoolResourceAlreadyExists extends RuntimeException {

    public SchoolResourceAlreadyExists(String message) {
        super(message);
    }

}
