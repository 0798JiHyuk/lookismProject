package org.ict.lookism.item.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.ict.lookism.board.entity.Board;
import org.ict.lookism.item.entity.Item;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{


}
