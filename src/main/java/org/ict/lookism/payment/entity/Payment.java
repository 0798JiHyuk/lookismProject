package org.ict.lookism.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment /* implements java.io.Serializable */ {
    //private static final long serialVersionUID = -5219066150385199445L;
    private String paymentId;
    private String userId;
    private String itemId;
    private int itemPrice;
    private String itemMethod;
    private Timestamp paymentDate;
    private String paymentStatus;
    private Timestamp refundDate;
    private String paymentKey;
    private String usageStatus;
    private int coinleftNum;

  

  
}
