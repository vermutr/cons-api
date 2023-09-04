package com.verti.consapi.controller.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferResponse {

    private String id;

    private String title;

    private String description;

    private Double price;

    private String email;

}
