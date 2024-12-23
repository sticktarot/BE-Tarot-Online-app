package app.tarot.be.entity;

import app.tarot.be.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "rank")
@AllArgsConstructor
@NoArgsConstructor
public class Rank  extends BaseEntityLazy {
	@Id
	@Column(name = "rank_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long rankId;

  @Column(name = "rank_name", length = 50)
  private String rankName;

	@OneToMany(mappedBy = "rank")
	private List<Account> accounts;
}
