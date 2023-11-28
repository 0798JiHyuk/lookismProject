package org.ict.lookism.coin.repository;

import org.ict.lookism.coin.entity.Coin;
import org.ict.lookism.common.Paging;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository {  //클래스명과 매퍼 xml 파일명이 같아야 함
	
	//주의 : 매퍼 xml 안의 각 element 의 id 명과 메소드명이 반드시 같아야 함
	public int selectListCount(String userId);
	public List<Coin> selectUsedList(Paging paging, String userId);
	public int insertRCoin(Coin coin);
	public int insertICoin(Coin coin);
}
