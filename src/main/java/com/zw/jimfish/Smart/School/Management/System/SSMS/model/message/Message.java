package com.zw.jimfish.Smart.School.Management.System.SSMS.model.message;

import com.zw.jimfish.Smart.School.Management.System.SSMS.model.user.User;
import com.zw.jimfish.Smart.School.Management.System.SSMS.utilities.Audit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "messages", indexes = {
        @Index(name = "idx_message_sender", columnList = "sender_id"),
        @Index(name = "idx_message_recipient", columnList = "recipient_id"),
        @Index(name = "idx_message_date", columnList = "dateSent")
})
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id", nullable = false)
    private User recipient;

    @NotBlank
    @Size(max = 1000)
    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime dateSent;

    @Column
    private boolean read = false;

    @Embedded
    private Audit audit;
}