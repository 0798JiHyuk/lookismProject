package org.ict.lookism.star.service;

import org.ict.lookism.star.entity.Star;

import java.util.List;

public interface StarService {
    int insertStar(Star star);

    int updateStar(Star star);

    int deleteStar(String starId);

    Star selectStarById(String starId);

    List<Star> selectStarList();
}