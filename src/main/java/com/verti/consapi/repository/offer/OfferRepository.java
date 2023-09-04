package com.verti.consapi.repository.offer;

import com.verti.consapi.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {

    @Query("select offer from Offer offer where offer.customer.email = :email")
    List<Offer> findAllByCustomerEmail(@Param("email") String email);

}
