package it.projectalpha.movieinfo.models;

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
