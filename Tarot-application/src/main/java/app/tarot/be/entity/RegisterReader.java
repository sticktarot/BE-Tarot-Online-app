package app.tarot.be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@Table(name = "register_reader")
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReader{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false,length = 100)
    private String fullName;

    @Column(name = "gender", nullable = false)
    private int gender;

    @Column(name = "dob", nullable = false)
    private String dob;

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

    @Embedded
    @NonNull
    private Address address;

    @Column(name = "link_facebook", nullable = false)
    private String linkFacebook;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "process_interview", nullable = false)
    private Integer processInterview;

    @Column(name = "file_test_url", nullable = false)
    private String fileTestUrl;

    @Column(name = "file_test_name", nullable = false)
    private String fileTestName;

    @Column(name = "note", nullable = false)
    private String note;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "acc_id")
    private Account account;
}
