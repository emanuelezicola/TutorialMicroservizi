package it.projectalpha.moviecatalog.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieCatalog {

    private String name;
    private String description;
    private int rating;

}