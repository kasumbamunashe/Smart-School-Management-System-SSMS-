package com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Audit {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedAt;
    private String createdBy;
    private String modifiedBy;


    public Audit() {
        setCreatedAt(LocalDateTime.now());
        setUpdatedAt(LocalDateTime.now());
    }

    public Audit(LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.createdAt = createdDate;
        this.updatedAt = modifiedDate;
    }

}
