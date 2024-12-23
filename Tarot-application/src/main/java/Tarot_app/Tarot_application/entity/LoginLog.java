package Tarot_app.Tarot_application.entity;

import Tarot_app.Tarot_application.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "login_log")
@AllArgsConstructor
@NoArgsConstructor
public class LoginLog extends BaseEntityLazy {
  @Id
  @Column(name = "log_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int logId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
  private Account account;

  @Column(name = "datetime")
  private LocalDateTime datetime;

  @Column(name = "ip_address")
  private String ipAddress;

  @Column(name = "location")
  private String location;
}
