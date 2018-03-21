package com.cvs.PIM.auditing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

// Creating implementation of AuditorAware and override its methods to provide currently logged in user
@Component
class AuditorAwareImpl implements AuditorAware<String> {

    @Value("${spring.datasource.username}")
    String databaseUser;

    @Override
    public String getCurrentAuditor() {
        return databaseUser;
        // Can use Spring Security to return currently logged in user
//         return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
    }
}