package org.ict.lookism.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="payment")
public class Payment{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String paymentId;
    private String userId;
    private String itemId;
    private int itemPrice;
    private String itemMethod;
    @CreationTimestamp
    private Timestamp paymentDate;
    private String paymentStatus;
    @CreationTimestamp
    private Timestamp refundDate;
    private String paymentKey;
    private String usageStatus;
    private int coinleftNum;

  

  
}
