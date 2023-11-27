package org.ict.lookism.coin.service;

import org.ict.lookism.coin.entity.Coin;
import org.ict.lookism.coin.repository.CoinRepository;
import org.ict.lookism.common.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("coinService")
@Transactional
public class CoinServiceImpl implements CoinService {
	@Autowired
	private CoinRepository coinRepository;
	
	@Override
	public int selectListCount(String userId) {
		return coinRepository.selectListCount();
	}

	@Override
	public List<Coin> selectUsedList(Paging paging, String userId) {
		List<Coin> list = coinRepository.selectUsedList(paging, userId);
		return (ArrayList<Coin>) list;
	}

	@Override
	public int insertICoin(Coin coin) {
		return coinRepository.insertICoin(coin);
	}
	
	@Override
	public int insertRCoin(Coin coin) {
		return coinRepository.insertRCoin(coin);
	}


}
