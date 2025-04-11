package com.zw.jimfish.Smart.School.Management.System.SSMS.model.subject;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.classes.AcademicClass;
import com.zw.jimfish.Smart.School.Management.System.SSMS.model.timetable.TimetableEntry;
import com.zw.jimfish.Smart.School.Management.System.SSMS.utilities.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, unique = true)
    private String name;

    @Size(max = 500)
    private String description;

    @ManyToMany(mappedBy = "subjects")
    private Set<AcademicClass> academicClasses;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<TimetableEntry> timetableEntries;

    @Embedded
    private Audit audit;

    @Column(nullable = false)
    private boolean active = true;
}