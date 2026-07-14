package com.sprint.mission.discodeit.controller;


import com.sprint.mission.discodeit.controller.api.NotificationApi;
import com.sprint.mission.discodeit.dto.data.NotificationDto;
import com.sprint.mission.discodeit.security.DiscodeitUserDetails;
import com.sprint.mission.discodeit.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/notifications")
public class NotificationController implements NotificationApi {

    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<NotificationDto>> findAll(
            @AuthenticationPrincipal DiscodeitUserDetails userDetails) {
        log.info("알림 목록 조회 요청: receiverId={}", userDetails.getUserDto().id());
        List<NotificationDto> notifications = notificationService.findAllByReceiverId(
                userDetails.getUserDto().id());
        log.debug("알림 목록 조회 응답: count={}", notifications.size());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(notifications);
    }
}
