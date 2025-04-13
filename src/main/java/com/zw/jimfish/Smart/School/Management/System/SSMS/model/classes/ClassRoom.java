package com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "classrooms", indexes = {
        @Index(name = "idx_classroom_name", columnList = "name", unique = true),
        @Index(name = "idx_classroom_code", columnList = "code", unique = true)
})
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, unique = true)
    private String code;

    @Size(max = 200)
    private String description;

    @Column(name = "capacity")
    private Integer capacity;

    @Embedded
    private Audit audit;

    @Column(nullable = false)
    private boolean active = true;
}
