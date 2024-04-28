package com.ritesh.UserAuth.GMailControls;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class GMailEntity {
    @Getter @Setter
    private String To;
    @Getter @Setter
    private String From;
    @Getter @Setter
    private String Text;
    @Getter @Setter
    private Long OTP;
    @Getter @Setter
    private String Subject;
}
