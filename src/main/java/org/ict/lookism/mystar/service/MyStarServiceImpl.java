package org.ict.lookism.mystar.service;

import org.ict.lookism.mystar.entity.MyStar;
import org.ict.lookism.mystar.repository.MyStarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("myStarService")
@Transactional
public class MyStarServiceImpl implements MyStarService {
	@Autowired
	private MyStarRepository myStarMapper;

	@Override
	public int insertMyStar(MyStar myStar) {
		return myStarMapper.insertMyStar(myStar);
	}

	@Override
	public int deleteMyStar(MyStar myStar) {
		return myStarMapper.deleteMyStar(myStar);
	}

	@Override
	public MyStar selectMyStar(MyStar myStar) {
		return myStarMapper.selectMyStar(myStar);
	}
}