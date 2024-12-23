package app.tarot.be.entity;

import app.tarot.be.entity.core.BaseEntityLazy;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "media_file")
@AllArgsConstructor
@NoArgsConstructor
public class MediaFile extends BaseEntityLazy {
  @Id
  @Column(name = "file_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long fileId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
  private UserProfile userProfile;

  @Column(name = "file_url")
  private String fileUrl;

  @Column(name = "file_type", length = 100)
  private String fileType;
}
