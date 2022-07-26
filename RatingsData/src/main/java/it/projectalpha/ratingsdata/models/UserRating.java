package it.projectalpha.ratingsdata.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRating {

    private List<Rating> userRatings;

}
