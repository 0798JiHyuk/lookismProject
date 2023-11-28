package org.ict.lookism.board.entity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.ict.lookism.common.SearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;

import static org.ict.lookism.board.entity.QBoard.board;

@RequiredArgsConstructor
@Repository
public class BoardRepositoryCustom {
  /*  private final JPAQueryFactory queryFactory;

    public Page<Board> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition){
        JPAQuery<Board> query = queryFactory.selectFrom(board)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();

        List<Board> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(board.writeDate.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }*/

    private BooleanExpression searchKeywords(String sk, String sv) {
        if ("boardtitle".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return board.boardtitle.contains(sv);
            }
        }
        return null;
    }


    public Page<Board> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {
        return null;
    }

}
