package org.ict.lookism.item.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.item.entity.Item;
import org.ict.lookism.item.repository.ItemRepository;
import org.ict.lookism.payment.repository.PaymentRepository;
import org.ict.lookism.payment.repository.PaymentRepositoryCustom;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;


    public List<Item> selectList(){
        return null;
    }

    public int updateDiscItem(String itemId){
        return 0;
    }

}
