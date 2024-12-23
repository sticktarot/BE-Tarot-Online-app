package Tarot_app.Tarot_application.entity;

import Tarot_app.Tarot_application.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "refresh_token")
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken extends BaseEntityLazy {
  @Id
  @Column(name = "token_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int tokenId;

  @ManyToOne
  @JoinColumn(name = "username", referencedColumnName = "username")
  private Account account;

  @Column(name = "device")
  private String device;

  @Column(name = "ip_address")
  private String ipAddress;

  @Column(name = "token")
  private String token;

  @Column(name = "expired_at")
  private LocalDateTime expiredAt;

  @Column(name = "is_revoked")
  private boolean isRevoked;

}
