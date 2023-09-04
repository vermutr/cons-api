package com.verti.consapi.config.security.util;


import com.verti.consapi.model.Customer;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    private SecurityUtil() {

    }

    public static String getCustomerId() {
        return ((Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

}
