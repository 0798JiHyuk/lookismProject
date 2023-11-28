package org.ict.lookism.looks.repository;

import org.apache.ibatis.annotations.*;
import org.ict.lookism.looks.entity.Looks;

import java.util.List;

@Mapper
public interface LooksRepository {
	@Select("SELECT sysdate FROM dual")
	String getTime();

	@Select("SELECT * FROM looks WHERE userId = #{userId}")
	Looks selectLooksById(String userId);

	@Insert("INSERT INTO looks (userId, starName, percent, looksDate) VALUES (#{userId}, #{starName}, #{percent}, #{looksDate})")
	int insertLooks(Looks looks);

	@Update("UPDATE looks SET starName = #{starName}, percent = #{percent}, looksDate = #{looksDate} WHERE userId = #{userId}")
	int updateLooks(Looks looks);

	@Delete("DELETE FROM looks WHERE userId = #{userId}")
	int deleteLooks(String userId);

	@Select("SELECT * FROM looks")
	List<Looks> selectLooksList();
}