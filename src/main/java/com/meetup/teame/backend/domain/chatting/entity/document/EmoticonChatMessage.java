package com.meetup.teame.backend.domain.chatting.entity.document;

import com.meetup.teame.backend.domain.chatting.entity.ChatMessageType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.TypeAlias;

import java.time.LocalDateTime;

@TypeAlias("EmoticonChatMessage")
@Getter
public class EmoticonChatMessage extends ChatMessage {
    private final String emoticon;

    @Builder
    private EmoticonChatMessage(String chatRoomId, Long senderId, String senderName, String senderImageUrl, LocalDateTime createdAt,
                                String emoticon) {
        super(chatRoomId, ChatMessageType.EMOTICON, senderId, senderName, senderImageUrl, createdAt);
        this.emoticon = emoticon;
    }

    public static EmoticonChatMessage of(String chatRoomId, Long senderId, String senderName, String senderImageUrl, LocalDateTime createdAt,
                                         String emoticon) {
        return EmoticonChatMessage.builder()
                .chatRoomId(chatRoomId)
                .senderId(senderId)
                .senderName(senderName)
                .senderImageUrl(senderImageUrl)
                .createdAt(createdAt)
                .emoticon(emoticon)
                .build();
    }

    @Override
    public String getMessage() {
        return emoticon;//todo 수정 필요 (기쁨) (슬픔)같은 걸로 이모티콘 키워드로 표시되게 변경해야 할듯
    }
}
