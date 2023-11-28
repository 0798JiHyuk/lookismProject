package org.ict.lookism.item.repository;


import org.ict.lookism.item.entity.Item;

import java.util.List;


public interface ItemRepository {  //클래스명과 매퍼 xml 파일명이 같아야 함
	
	//주의 : 매퍼 xml 안의 각 element 의 id 명과 메소드명이 반드시 같아야 함
	public List<Item> selectList();
	public int updateDiscItem(String itemId);
}
