package com.zw.jimfish.Smart.School.Management.System.SSMS.repository.attendance;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.attendance.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Long> {
}
