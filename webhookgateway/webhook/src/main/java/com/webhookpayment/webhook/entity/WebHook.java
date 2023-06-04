package com.webhookpayment.webhook.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebHook {
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long Id;
    private String eventName;
    private String status;
    private String payload;
}
