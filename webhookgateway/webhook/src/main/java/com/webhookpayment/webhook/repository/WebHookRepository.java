package com.webhookpayment.webhook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webhookpayment.webhook.entity.WebHook;

public interface WebHookRepository extends JpaRepository<WebHook,Long>{
    
}
