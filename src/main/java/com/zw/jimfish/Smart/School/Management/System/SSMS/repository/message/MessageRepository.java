package com.zw.jimfish.Smart.School.Management.System.SSMS.repository.message;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
