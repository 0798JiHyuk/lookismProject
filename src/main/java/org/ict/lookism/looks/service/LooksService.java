package org.ict.lookism.looks.service;

import org.ict.lookism.looks.entity.Looks;

import java.util.List;

public interface LooksService {

    int insertLooks(Looks looks);

    int updateLooks(Looks looks);

    int deleteLooks(String userId);

    List<Looks> selectLooksList();
}