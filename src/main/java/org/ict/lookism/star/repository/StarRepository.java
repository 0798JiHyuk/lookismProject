package org.ict.lookism.star.repository;

import org.apache.ibatis.annotations.*;
import org.ict.lookism.star.entity.Star;

import java.util.List;

@Mapper
public interface StarRepository {
	@Insert("INSERT INTO star (starId, starName, starGender, starJob) " +
			"VALUES (#{starId}, #{starName}, #{starGender}, #{starJob})")
	int insertStar(Star star);

	@Update("UPDATE star SET starName = #{starName}, starGender = #{starGender}, " +
			"starJob = #{starJob} WHERE starId = #{starId}")
	int updateStar(Star star);

	@Delete("DELETE FROM star WHERE starId = #{starId}")
	int deleteStar(String starId);

	@Select("SELECT * FROM star WHERE starId = #{starId}")
	Star selectStarById(String starId);

	@Select("SELECT * FROM star")
	List<Star> selectStarList();
}