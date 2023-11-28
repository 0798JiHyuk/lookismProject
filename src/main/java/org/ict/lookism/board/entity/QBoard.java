package org.ict.lookism.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    public static final QBoard board = new QBoard("board");

    public final StringPath boardcontent = createString("boardcontent");

    public final DateTimePath<java.time.LocalDateTime> writeDate = createDateTime("bardwritedate", java.time.LocalDateTime.class);

    public final StringPath boardfile = createString("boardfile");

    public final StringPath boardimg = createString("boardimg");

    public final NumberPath<Long> boardid = createNumber("boardid", Long.class);

    public final StringPath boardtitle = createString("boardtitle");

    public QBoard(String variable) {
        super(Board.class, forVariable(variable));
    }

    public QBoard(Path<? extends Board> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoard(PathMetadata metadata) {
        super(Board.class, metadata);
    }
}
