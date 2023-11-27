package org.ict.lookism.item.service;

import org.ict.lookism.item.entity.Item;

import java.util.List;

public interface ItemService {
	
    List<Item> selectList();

    int updateDiscItem(String itemId);

}
