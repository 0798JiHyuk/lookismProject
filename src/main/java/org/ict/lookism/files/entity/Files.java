package org.ict.lookism.files.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="files")
public class Files {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String fileId;
    private String userId;
    private String boardId;
    private String boardName;
    private String fileName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private Timestamp regDate;
    private String delYn = "N";
    @JsonFormat(pattern = "yyyy-MM-dd")
    @LastModifiedDate
    private String delDate;

}
