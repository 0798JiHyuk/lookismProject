package org.ict.lookism.star.service;

import org.ict.lookism.star.entity.Star;
import org.ict.lookism.star.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("starService")
@Transactional
public class StarServiceImpl implements StarService {
	@Autowired
	private StarRepository starMapper;

	@Override
	public int insertStar(Star star) {
		return starMapper.insertStar(star);
	}

	@Override
	public int updateStar(Star star) {
		return starMapper.updateStar(star);
	}

	@Override
	public int deleteStar(String starId) {
		return starMapper.deleteStar(starId);
	}

	@Override
	public Star selectStarById(String starId) {
		return starMapper.selectStarById(starId);
	}

	@Override
	public List<Star> selectStarList() {
		return starMapper.selectStarList();
	}
}