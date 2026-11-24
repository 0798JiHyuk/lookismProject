package org.ict.lookism.board;

import org.springframework.data.jpa.repository.JpaRepository;

interface BoardRepository extends JpaRepository<BoardPost, Long> {}
