package org.cloud.project.user.role;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.cloud.project.user.jwt.JwtProvider;
import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@SecurityRequirement(name = JwtProvider.AUTHORIZATION)
@Secured(UserAuthNames.ROLE_USER)
public @interface UserAuth {
}
