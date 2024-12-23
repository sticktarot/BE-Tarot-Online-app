package Tarot_app.Tarot_application.entity;

import Tarot_app.Tarot_application.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "group_permission")
@AllArgsConstructor
@NoArgsConstructor
public class GroupPermission extends BaseEntityLazy {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "group_id")
  private int permissionId;

  @OneToOne
  @JoinColumn(name = "role_group", referencedColumnName = "role_group")
  private RoleGroup roleGroup;

  @Column(name = "permissions")
  private String permissions;
}
