package com.verti.consapi.service.offer.impl;

import com.verti.consapi.controller.dto.offer.OfferRequest;
import com.verti.consapi.mapper.OfferMapper;
import com.verti.consapi.model.Customer;
import com.verti.consapi.model.Offer;
import com.verti.consapi.repository.offer.OfferRepository;
import com.verti.consapi.service.customer.CustomerService;
import com.verti.consapi.service.offer.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    private final CustomerService customerService;

    @Override
    @Transactional
    public Offer saveOffer(final OfferRequest offerRequest) {
        Customer customer = customerService.getCustomerByEmail(offerRequest.getEmail());
        if (customer == null) {
            throw new RuntimeException("User not exist");
        }

        Offer offer = OfferMapper.convertOfferRequestToOffer(offerRequest, customer);
        return offerRepository.save(offer);
    }

    @Override
    public List<Offer> getAllOffersByEmail(final String email) {
        return offerRepository.findAllByCustomerEmail(email);
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public void deleteOffer(String id) {
        offerRepository.deleteById(id);
    }

}
