package app.tarot.be.entity;

import app.tarot.be.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "user_profile")
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile extends BaseEntityLazy {

  @Id
  @Column(name = "acc_id")
  private Long accId;

  @Column(name = "full_name", nullable = false, length = 100)
  private String fullName;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "avatar", length = 65535)
  private String avatar;

  @Column(name = "gender", nullable = false)
  private int gender;

  @Column(name = "dob", nullable = false)
  private String dob;

  @Embedded
  @NonNull
  private Address address;

  @Column(name = "experience", length = 65535)
  private String experience;

  @Column(name = "strength", length = 65535)
  private String strength;

  @Column(name = "style", length = 65535)
  private String style;

  @Column(name = "deck")
  private String deck;

  @Column(name = "introduce", length = 65535)
  private String introduce;

  @OneToOne
  @MapsId
  @JoinColumn(name = "acc_id")
  private Account account;

  @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<MediaFile> mediaFiles;
}
