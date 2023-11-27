package org.ict.lookism.mystar.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.ict.lookism.mystar.entity.MyStar;

@Mapper
public interface MyStarRepository {
	@Insert("INSERT INTO mystar (userId, starId) VALUES (#{userId}, #{starId})")
	int insertMyStar(MyStar myStar);

	@Delete("DELETE FROM mystar WHERE userId = #{userId} AND starId = #{starId}")
	int deleteMyStar(MyStar myStar);

	@Select("SELECT * FROM mystar WHERE userId = #{userId} AND starId = #{starId}")
	MyStar selectMyStar(MyStar myStar);
}