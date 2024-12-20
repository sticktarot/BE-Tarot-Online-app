package Tarot_app.Tarot_application.entity;

import Tarot_app.Tarot_application.entity.core.BaseEntityLazy;
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
  private int accId;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "avatar", length = 65535)
  private String avatar;

  @Column(name = "gender")
  private int gender;

  @Column(name = "dob")
  private String dob;

  @Column(name = "address", length = 65535) // define text type
  private String address;

  @Column(name = "zodiac", length = 50)
  private String zodiac;

  @Column(name = "rank_name", length = 50)
  private String rankName;

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

  @Column(name = "address_city", length = 65535)
  private String addressCity;

  @OneToOne
  @MapsId
  @JoinColumn(name = "acc_id")
  private Account account;

  @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL)
  private List<MediaFile> mediaFiles;
}
