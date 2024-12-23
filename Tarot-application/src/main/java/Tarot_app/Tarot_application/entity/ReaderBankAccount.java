package Tarot_app.Tarot_application.entity;

import Tarot_app.Tarot_application.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "reader_bank_account")
@AllArgsConstructor
@NoArgsConstructor
public class ReaderBankAccount extends BaseEntityLazy {
  @Id
  @Column(name = "bank_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int bankId;

  @Column(name = "bank_number", length = 50)
  private String bankNumber;

  @Column(name = "full_name", length = 100)
  private String fullName;

  @Column(name = "bank_name")
  private String bankName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
  private Account account;

}
