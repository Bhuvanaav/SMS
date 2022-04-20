package com.student.sms.service;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditAwareImpl implements AuditorAware {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Bhuvana");

    }
}
