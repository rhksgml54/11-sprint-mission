package com.sprint.mission.discodeit.controller.api;

import com.sprint.mission.discodeit.dto.data.MessageDto;
import com.sprint.mission.discodeit.dto.request.MessageCreateRequest;
import com.sprint.mission.discodeit.dto.request.MessageUpdateRequest;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface MessageApi {

    ResponseEntity<MessageDto> create(
            @Parameter(description = "메시지 생성 정보") MessageCreateRequest messageCreateRequest,
            @Parameter(description = "첨부 파일 목록") List<MultipartFile> attachments
    );

    ResponseEntity<MessageDto> find(
            @Parameter(description = "조회할 메시지 ID") UUID messageId
    );

    ResponseEntity<List<MessageDto>> findAllByChannelId(
            @Parameter(description = "조회할 채널 ID") UUID channelId
    );

    ResponseEntity<MessageDto> update(
            @Parameter(description = "수정할 메시지 ID") UUID messageId,
            @Parameter(description = "수정할 메시지 정보") MessageUpdateRequest request
    );

    ResponseEntity<Void> delete(
            @Parameter(description = "삭제할 메시지 ID") UUID messageId
    );
}