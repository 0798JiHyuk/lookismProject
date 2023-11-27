package org.ict.lookism.item.service;

import org.ict.lookism.item.entity.Item;
import org.ict.lookism.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<Item> selectList() {
		List<Item> list = itemRepository.selectList();
		return (ArrayList<Item>) list;
	}

	@Override
	public int updateDiscItem(String itemId) {
		return itemRepository.updateDiscItem(itemId);
	}

}
