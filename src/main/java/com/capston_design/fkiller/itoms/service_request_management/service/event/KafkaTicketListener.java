package com.capston_design.fkiller.itoms.service_request_management.service.event;

import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketInformation;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketStatus;
import com.capston_design.fkiller.itoms.service_request_management.repository.TicketInformationRepository;
import com.capston_design.fkiller.itoms.service_request_management.service.dto.TicketCompletedMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaTicketListener {

    private final TicketInformationRepository ticketInformationRepository;

    @Value("${kafka.topic.ticket.completed:itoms.ticket.completed}")
    private String ticketCompletedTopic;

    @KafkaListener(topics = "#{'${kafka.topic.ticket.completed:itoms.ticket.completed}'}",
            groupId = "${spring.kafka.consumer.group-id:itoms-service-request-management}",
            containerFactory = "kafkaListenerContainerFactory")
    public void handleTicketCompleted(TicketCompletedMessage message) {
        log.info("[Kafka] ticket completed message received. ticketId={} incidentId={}", message.getTicketId(), message.getIncidentId());

        UUID ticketId = message.getTicketId();
        ticketInformationRepository.findByTicketId(ticketId).ifPresent(info -> {
            info.updateTicketStatus(TicketStatus.COMPLETE_EXECUTION);
            ticketInformationRepository.save(info);
            log.info("TicketInformation {} status updated to COMPLETE_EXECUTION", ticketId);
        });
    }
} 