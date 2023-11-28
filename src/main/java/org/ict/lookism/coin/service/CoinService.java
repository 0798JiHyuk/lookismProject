package org.ict.lookism.coin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.coin.entity.Coin;
import org.ict.lookism.coin.repository.CoinRepository;
import org.ict.lookism.common.Paging;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CoinService {
    private final CoinRepository coinRepository;

	public int selectListCount(String userId){
        return 0;
    }
	
    public List<Coin> selectUsedList(Paging paging, String userId){
        return null;
    }

    public int insertICoin(Coin coin){
        return 0;
    };

    public int insertRCoin(Coin coin){
        return 0;
    }

}
