package Tarot_app.Tarot_application.entity;

import Tarot_app.Tarot_application.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "role_name")
@AllArgsConstructor
@NoArgsConstructor
public class RoleGroup extends BaseEntityLazy {
  @Id
  @Column(name = "role_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int roleId;

  @Column(name = "role_name")
  private String roleName;

  @Column(name = "role_group", unique = true)
  private String roleGroup;

  @OneToOne(mappedBy = "roleGroup", cascade = CascadeType.ALL)
  private GroupPermission groupPermission;
}
