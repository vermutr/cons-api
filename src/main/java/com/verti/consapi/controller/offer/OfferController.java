package com.verti.consapi.controller.offer;

import com.verti.consapi.controller.dto.offer.OfferRequest;
import com.verti.consapi.controller.dto.offer.OfferResponse;
import com.verti.consapi.mapper.OfferMapper;
import com.verti.consapi.service.offer.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;


    @GetMapping
    public List<OfferResponse> getAllOffers() {
        return OfferMapper.convertOfferListToOfferResponseList(offerService.getAllOffers());
    }

    @GetMapping("/{email}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<OfferResponse> getAllCustomerOffers(@PathVariable("email") String email) {
        return OfferMapper.convertOfferListToOfferResponseList(offerService.getAllOffersByEmail(email));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_USER')")
    public OfferResponse createOffer(@RequestBody OfferRequest offerRequest) {
        return OfferMapper.convertOfferToOfferResponse(offerService.saveOffer(offerRequest));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void deleteOffer(@PathVariable("id") String id) {
        offerService.deleteOffer(id);
    }

}
