package app.tarot.be.entity;

import app.tarot.be.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "wallet_info")
@AllArgsConstructor
@NoArgsConstructor
public class WalletInfo extends BaseEntityLazy {
  @Id
  @Column(name = "acc_id")
  private Long accId;

  @Column(name = "account_balance")
  private Long accountBalance;

  @OneToOne
  @MapsId
  @JoinColumn(name = "acc_id")
  private Account account;
}
