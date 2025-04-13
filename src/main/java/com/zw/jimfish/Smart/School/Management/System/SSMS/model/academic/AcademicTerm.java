package com.zw.jimfish.Smart.School.Management.System.SSMS.model.academic;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.Audit;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.utilities.TermType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "academic_terms", indexes = {
        @Index(name = "idx_academic_term_session", columnList = "academic_session_id, term_type", unique = true)
})
public class AcademicTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_session_id", nullable = false)
    private AcademicSession academicSession;

    @Enumerated(EnumType.STRING)
    @Column(name = "term_type", nullable = false)
    private TermType termType; // FIRST_TERM, SECOND_TERM, THIRD_TERM, etc.

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "registration_deadline")
    private LocalDate registrationDeadline;

    @Embedded
    private Audit audit;

    @Column(nullable = false)
    private boolean current = false; // Mark current term
}