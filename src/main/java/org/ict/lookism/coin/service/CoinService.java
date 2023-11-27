package org.ict.lookism.coin.service;

import org.ict.lookism.coin.entity.Coin;
import org.ict.lookism.common.Paging;

import java.util.List;

public interface CoinService {
	
	int selectListCount(String userId);
	
    List<Coin> selectUsedList(Paging paging, String userId);

    int insertICoin(Coin coin);

    int insertRCoin(Coin coin);

}
