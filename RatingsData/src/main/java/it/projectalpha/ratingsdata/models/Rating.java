package it.projectalpha.ratingsdata.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Rating {

    private Long movieId;
    private int rating;

}
