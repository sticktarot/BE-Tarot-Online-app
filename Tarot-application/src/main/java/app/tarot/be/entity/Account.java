package app.tarot.be.entity;

import app.tarot.be.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntityLazy {
  @Id
  @Column(name = "acc_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accId;

  @Column(name = "username", nullable = false, unique = true, length = 100)
  private String username;

  @Column(name = "password", nullable = false, length = 100)
  private String password;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "phone_number", nullable = false, length = 20, unique = true)
  private String phoneNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rank_id", referencedColumnName = "rank_id")
  private Rank rank;

  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
  private UserProfile userProfile;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<LoginLog> loginLogs;

  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
  private WalletInfo walletInfo;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
  private List<ReaderBankAccount> readerBankAccounts;
}
