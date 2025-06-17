package com.capston_design.fkiller.itoms.service_request_management.service.event;

import com.capston_design.fkiller.itoms.service_request_management.client.dto.request.UpdateTicketStatusRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.service.dto.TicketStatusUpdateEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaTicketStatusPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.ticket.status.update:itoms.ticket.status.update}")
    private String ticketStatusUpdateTopic;

    @Async
    @EventListener
    public void handleTicketStatusUpdateEvent(TicketStatusUpdateEvent event) {
        UpdateTicketStatusRequestDTO dto = new UpdateTicketStatusRequestDTO(
                event.getTicketId(), event.getTicketName(), event.getTicketStatus(), event.getCompletionTime());
        kafkaTemplate.send(ticketStatusUpdateTopic, event.getTicketId().toString(), dto);
        log.info("[Kafka] ticket status update event published. ticketId={} status={}", event.getTicketId(), event.getTicketStatus());
    }
} 