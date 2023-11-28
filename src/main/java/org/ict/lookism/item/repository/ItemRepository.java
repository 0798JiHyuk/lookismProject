package org.ict.lookism.item.repository;


import org.ict.lookism.item.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository {

	public List<Item> selectList();
	public int updateDiscItem(String itemId);
}
