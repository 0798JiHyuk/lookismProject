package org.ict.lookism.mystar.service;

import org.ict.lookism.mystar.entity.MyStar;

public interface MyStarService {
    int insertMyStar(MyStar myStar);

    int deleteMyStar(MyStar myStar);

    MyStar selectMyStar(MyStar myStar);
}