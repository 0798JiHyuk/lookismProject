package org.ict.lookism.coin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // @ToString, @EqualsAndHashCode, @Getter/@Setter, @RequiredArgsConstructor 모두 사용한 것과 같음
@NoArgsConstructor
@AllArgsConstructor
public class Coin /* implements java.io.Serializable */ {
	//private static final long serialVersionUID = -5219066150385199445L;
	private String coinpayId;
	private String userId;
	private int coinUseNum;
	private TimeStamp coinDate;
	private String coinUse;
}
