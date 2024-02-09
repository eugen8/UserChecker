package eugen.fdetect.usercheck.service;

import eugen.fdetect.usercheck.client.PhoneNumberValidResponse;
import eugen.fdetect.usercheck.client.PhoneNumberValidationClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneValidationService {
    PhoneNumberValidationClient phoneNumberValidationClient;

    public boolean isValidPhone(String phone) {
        PhoneNumberValidResponse response = phoneNumberValidationClient.makeAbstractRequest(phone);
        return Boolean.TRUE.equals(response.getValid());
    }

}
