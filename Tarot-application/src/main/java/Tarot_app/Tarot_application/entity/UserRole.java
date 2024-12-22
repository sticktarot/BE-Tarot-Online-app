package Tarot_app.Tarot_application.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "user_role")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
  @Id
  @Column(name = "role_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int roleId;

  @ManyToOne
  @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
  private Account account;

  @ManyToOne
  @JoinColumn(name = "role_group_id", referencedColumnName = "role_id")
  private RoleGroup roleGroup;
}
