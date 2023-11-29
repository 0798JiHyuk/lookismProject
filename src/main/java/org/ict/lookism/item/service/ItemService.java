package org.ict.lookism.item.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.item.dto.ItemDto;
import org.ict.lookism.item.entity.Item;
import org.ict.lookism.item.repository.ItemRepository;
import org.ict.lookism.payment.repository.PaymentRepository;
import org.ict.lookism.payment.repository.PaymentRepositoryCustom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;


    public List<Item> selectList(){
        List<Item> item = itemRepository.findAll();

        log.info(item.toString());

        return item;
    }

    public int updateDiscItem(String itemId){
        return 0;
    }

}
