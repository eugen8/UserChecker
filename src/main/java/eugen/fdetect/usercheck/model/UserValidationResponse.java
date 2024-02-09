package eugen.fdetect.usercheck.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class UserValidationResponse implements Serializable {
    boolean isValid;
}
