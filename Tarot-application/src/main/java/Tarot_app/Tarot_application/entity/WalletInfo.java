package Tarot_app.Tarot_application.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "wallet_info")
@AllArgsConstructor
@NoArgsConstructor
public class WalletInfo {
  @Id
  @Column(name = "acc_id")
  private int accId;

  @Column(name = "account_balance")
  private Long accountBalance;

  @OneToOne
  @MapsId
  @JoinColumn(name = "acc_id")
  private Account account;
}
