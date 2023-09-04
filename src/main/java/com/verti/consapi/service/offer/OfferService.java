package com.verti.consapi.service.offer;

import com.verti.consapi.controller.dto.offer.OfferRequest;
import com.verti.consapi.model.Offer;

import java.util.List;

public interface OfferService {

    Offer saveOffer(final OfferRequest offerRequest);

    List<Offer> getAllOffersByEmail(final String email);

    List<Offer> getAllOffers();

    void deleteOffer(final String id);
}
