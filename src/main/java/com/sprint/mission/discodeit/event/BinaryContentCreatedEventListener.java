package com.sprint.mission.discodeit.event;

import com.sprint.mission.discodeit.storage.BinaryContentStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;


@Slf4j
@RequiredArgsConstructor
@Component
public class BinaryContentCreatedEventListener {

    private final BinaryContentStorage binaryContentStorage;

    @TransactionalEventListener
    public void on(BinaryContentCreatedEvent event) {
        log.debug("바이너리 데이터 저장 시작: id={}", event.binaryContentId());
        binaryContentStorage.put(event.binaryContentId(), event.bytes());
        log.info("바이너리 데이터 저장 완료: id={}", event.binaryContentId());
    }
}
