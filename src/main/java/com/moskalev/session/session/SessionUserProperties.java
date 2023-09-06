package com.moskalev.session.session;

import lombok.Data;
import lombok.Getter;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties("session")
@Validated
public class SessionUserProperties {

    @Getter
    @Setter
    private List<UserInfo> users = new ArrayList<>();

    @Data
    public static class UserInfo {

        @NotBlank
        private String username;
        @NotNull
        @Positive
        private Integer maximumMessage;
        @NotNull
        @Positive
        private Integer maximumSession;
        @NotNull
        private Duration sessionTimeout;
    }
}
