package org.cloud.project.user.adapter.in.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.cloud.project.common.WebAdapter;
import org.cloud.project.common.entity.UserEntity;
import org.cloud.project.user.application.port.in.MyInfoCommand;
import org.cloud.project.user.application.port.in.MyInfoUseCase;
import org.cloud.project.common.jwt.AppAuthentication;
import org.cloud.project.common.role.UserAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Tag(name = "내 정보 컨트롤러", description = "내 정보 관련 컨트롤러")
public class MyInfoController {

    private final MyInfoUseCase useCase;

    /**
     * 유저 정보 가져오기
     */
    @UserAuth
    @GetMapping("/getAuthor")
    public String getAuthor(AppAuthentication auth) {
        MyInfoCommand command = MyInfoCommand.builder()
                .userId(auth.getUserId())
                .build();
        UserEntity myInfo = useCase.getMyInfo(command);
        return myInfo.getName();
    }

    @UserAuth
    @GetMapping("/my")
    public ResponseMyInfo getMyInfo(AppAuthentication auth) {
        MyInfoCommand command = MyInfoCommand.builder()
                .userId(auth.getUserId())
                .build();

        UserEntity entity = useCase.getMyInfo(command);
        return new ResponseMyInfo(entity);
    }


}
