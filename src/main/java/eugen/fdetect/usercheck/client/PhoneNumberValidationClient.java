package eugen.fdetect.usercheck.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;

@Service
public class PhoneNumberValidationClient {

    @Value("${isMock}")
    protected boolean isMock = false;

    @Value("${abstractServiceApiKey:notfound}")
    protected String abstracServiceApiKey;

    public PhoneNumberValidResponse makeAbstractRequest(String phoneNumber) {
        if (isMock) {
            if("1234".equals(phoneNumber)){
                return new PhoneNumberValidResponse("1234", false, null);
            } else if("000".equals(phoneNumber)){
                throw new RuntimeException("Could not connect to the service");
            }
            return new PhoneNumberValidResponse("14152007986", true, new PhoneNumberFormat("+14152007986", "(415) 200-7986", "US"));
        }
        RestClient client = RestClient.create();
        return client.get().uri(String.format("https://phonevalidation.abstractapi.com/v1/?api_key=%s&phone=%s", abstracServiceApiKey, phoneNumber))
                .retrieve().body(PhoneNumberValidResponse.class);
    }
}

//response example: {"phone":"14152007986","valid":true,"format":{"international":"+14152007986","local":"(415) 200-7986"},"country":{"code":"US","name":"United States","prefix":"+1"},"location":"San Francisco, California","type":"landline","carrier":"O1 Communications"}