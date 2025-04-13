package com.zw.jimfish.Smart.School.Management.System.SSMS.model.academic;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "academic_sessions", indexes = {
        @Index(name = "idx_academic_session_name", columnList = "name", unique = true)
})
public class AcademicSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, unique = true)
    private String name; // e.g., "2023-2024"

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "academicSession", cascade = CascadeType.ALL)
    private List<AcademicTerm> terms;

    @Embedded
    private Audit audit;

    @Column(nullable = false)
    private boolean current = false; // Mark current session
}