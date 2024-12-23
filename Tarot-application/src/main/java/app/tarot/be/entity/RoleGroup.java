package app.tarot.be.entity;

import app.tarot.be.entity.core.BaseEntityLazy;
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
  private Long roleId;

  @Column(name = "role_name")
  private String roleName;

  @Column(name = "role_group", unique = true)
  private String roleGroup;

  @OneToOne(mappedBy = "roleGroup", cascade = CascadeType.ALL)
  private GroupPermission groupPermission;
}
