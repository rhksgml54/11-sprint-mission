package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.dto.data.NotificationDto;
import com.sprint.mission.discodeit.mapper.NotificationMapper;
import com.sprint.mission.discodeit.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BasicNotificationService implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Transactional(readOnly = true)
    @Override
    public List<NotificationDto> findAllByReceiverId(UUID receiverId) {
        log.debug("사용자별 알림 목록 조회 시작: receiverId={}", receiverId);
        List<NotificationDto> dtos =
                notificationRepository.findAllByReceiverId(receiverId).stream()
                        .map(notificationMapper::toDto)
                        .toList();
        log.info("사용자별 알림 목록 조회 완료: receiverId={}, 조회된 항목 수={}", receiverId, dtos.size());
        return dtos;
    }
}
