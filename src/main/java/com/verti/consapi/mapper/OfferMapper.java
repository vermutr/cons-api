package com.verti.consapi.mapper;


import com.verti.consapi.controller.dto.offer.OfferRequest;
import com.verti.consapi.controller.dto.offer.OfferResponse;
import com.verti.consapi.model.Customer;
import com.verti.consapi.model.Offer;

import java.util.List;

public class OfferMapper {

    private OfferMapper() {

    }

    public static OfferResponse convertOfferToOfferResponse(Offer offer) {
        OfferResponse offerResponse = new OfferResponse();
        offerResponse.setId(offer.getId());
        offerResponse.setTitle(offer.getTitle());
        offerResponse.setDescription(offer.getDescription());
        offerResponse.setPrice(offer.getPrice());
        offerResponse.setEmail(offer.getCustomer().getEmail());
        return offerResponse;
    }

    public static List<OfferResponse> convertOfferListToOfferResponseList(List<Offer> offers) {
        return offers.stream().map(OfferMapper::convertOfferToOfferResponse).toList();
    }

    public static Offer convertOfferRequestToOffer(OfferRequest offerRequest, Customer customer) {
        Offer offer = new Offer();
        offer.setTitle(offerRequest.getTitle());
        offer.setDescription(offerRequest.getDescription());
        offer.setPrice(offerRequest.getPrice());
        offer.setCustomer(customer);
        return offer;
    }

}
