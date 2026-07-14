package com.sprint.mission.discodeit.controller.api;

import com.sprint.mission.discodeit.dto.data.NotificationDto;
import com.sprint.mission.discodeit.security.DiscodeitUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

@Tag(name = "Notification", description = "알림 API")
public interface NotificationApi {

    @Operation(summary = "알림 목록 조회")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "알림 목록 조회 성공",
                    content = @Content(array = @ArraySchema(schema = @Schema(
                            implementation = NotificationDto.class)))
            ),
            @ApiResponse(
                    responseCode = "401", description = "인증되지 않은 요청"
            )
    })
    ResponseEntity<List<NotificationDto>> findAll(
            @Parameter(hidden = true) @AuthenticationPrincipal
            DiscodeitUserDetails userDetails
    );
}
