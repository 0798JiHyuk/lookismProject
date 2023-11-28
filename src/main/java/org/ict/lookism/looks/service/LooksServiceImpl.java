package org.ict.lookism.looks.service;

import org.ict.lookism.looks.entity.Looks;
import org.ict.lookism.looks.repository.LooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("looksService")
@Transactional
public class LooksServiceImpl implements LooksService {
	@Autowired
	private LooksRepository looksMapper;

	@Override
	public int insertLooks(Looks looks) {
		return looksMapper.insertLooks(looks);
	}

	@Override
	public int updateLooks(Looks looks) {
		return looksMapper.updateLooks(looks);
	}

	@Override
	public int deleteLooks(String userId) {
		return looksMapper.deleteLooks(userId);
	}

	@Override
	public List<Looks> selectLooksList() {
		return looksMapper.selectLooksList();
	}
}