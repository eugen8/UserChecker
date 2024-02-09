package eugen.fdetect.usercheck.client;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumberValidResponse {
    private String phone;
    private Boolean valid;
    private PhoneNumberFormat format;
}


