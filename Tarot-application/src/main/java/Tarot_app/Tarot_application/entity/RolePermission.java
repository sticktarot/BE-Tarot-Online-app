package Tarot_app.Tarot_application.entity;

import Tarot_app.Tarot_application.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "role_permission")
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission extends BaseEntityLazy {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "permission_id")
  private int permissionId;

  @OneToOne
  @JoinColumn(name = "role_group", referencedColumnName = "role_group")
  private RoleName roleName;

  @Column(name = "permissions")
  private String permissions;
}
