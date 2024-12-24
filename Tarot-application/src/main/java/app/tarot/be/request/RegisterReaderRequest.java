package app.tarot.be.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReaderRequest {
    @Email
    @NotBlank(message = "{email.required}")
    private String email;
    private String phoneNumber;
    private String linkFaceBook;
    private String firstName;
    private String lastName;
    private Long dateOfBirth;
    private String gender;
    private String city;
    private String district;
    private String ward;
    private String addressDetail;
    private String exp;
    private String deck;
    private List<String> strengths;
    private List<String> styleTarot;
    private String note;
}
