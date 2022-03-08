package it.projectalpha.moviecatalog.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Rating {

    private Long movieId;
    private int ratingValue;

}
