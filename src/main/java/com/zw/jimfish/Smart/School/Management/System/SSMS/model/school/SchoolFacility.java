package com.zw.jimfish.Smart.School.Management.System.SSMS.model.school;

import com.zw.jimfish.Smart.School.Management.System.SSMS.utilities.Audit;
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
@Table(name = "school_facilities", indexes = {
        @Index(name = "idx_facility_name", columnList = "name", unique = true)
})
public class SchoolFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, unique = true)
    private String name; // e.g., "Library", "Science Lab", "Sports Field"

    @Size(max = 500)
    private String description;

    @Column(name = "capacity")
    private Integer capacity;

    @Embedded
    private Audit audit;

    @Column(nullable = false)
    private boolean active = true;
}