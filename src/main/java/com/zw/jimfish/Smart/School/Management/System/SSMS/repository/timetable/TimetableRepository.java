package com.zw.jimfish.Smart.School.Management.System.SSMS.repository.timetable;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.timetable.TimetableEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<TimetableEntry, Long> {
}
