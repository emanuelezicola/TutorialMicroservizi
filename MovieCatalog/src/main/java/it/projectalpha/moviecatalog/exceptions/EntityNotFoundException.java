package it.projectalpha.moviecatalog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EntityNotFoundException extends RuntimeException {

    private String message;

}
