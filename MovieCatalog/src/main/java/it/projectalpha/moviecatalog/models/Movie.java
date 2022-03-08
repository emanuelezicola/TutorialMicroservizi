package it.projectalpha.moviecatalog.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Movie {

    private Long movieId;
    private String name;

}
