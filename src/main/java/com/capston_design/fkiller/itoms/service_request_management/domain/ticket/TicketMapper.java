package com.capston_design.fkiller.itoms.service_request_management.domain.ticket;

import com.capston_design.fkiller.itoms.service_request_management.client.dto.response.TicketInformationDTO;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TicketInformationResponseDTO;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketMapper {

    private final TicketCreator ticketCreator;

    public List<TicketDomain> toTicketDomainList(List<TicketInformationDTO> ticketInformationDTOList) {
        return ticketInformationDTOList.stream()
                .map(this::toTicketDomain)
                .toList();
    }

    public TicketDomain toTicketDomain(TicketInformationDTO ticketInformationDTO) {
            return ticketCreator.createInitTicket(ticketInformationDTO.getTicketId(),
                    ticketInformationDTO.getIncidentId(),
                    ticketInformationDTO.getTicketName(),
                    ticketInformationDTO.getTicketContent(),
                    ticketInformationDTO.getTicketStatus(),
                    ticketInformationDTO.getCreatorId(),
                    ticketInformationDTO.getCreatorName(),
                    ticketInformationDTO.getAcceptorId(),
                    ticketInformationDTO.getAcceptorName());
    }

    public List<TicketInformation> toTicketInformationEntityList(List<TicketDomain> ticketDomainList) {
        return ticketDomainList.stream()
                .map(this::toTicketInformationEntity)
                .toList();
    }

    public TicketInformation toTicketInformationEntity(TicketDomain ticketDomain) {
        return TicketInformation.builder()
                .ticketId(ticketDomain.getTicketId())
                .incidentId(ticketDomain.getIncidentId())
                .ticketName(ticketDomain.getTicketName())
                .ticketStatus(ticketDomain.getTicketStatus())
                .creatorId(ticketDomain.getCreatorId())
                .creatorName(ticketDomain.getCreatorName())
                .chargerId(ticketDomain.getChargerId())
                .chargerName(ticketDomain.getChargerName())
                .build();
    }

    public List<TicketInformationResponseDTO> toTicketInformationResponseDTOList(
            List<TicketDomain> ticketDomainList) {
        return ticketDomainList.stream()
                .map(this::toTicketInformationResponseDTO)
                .toList();
    }

    public TicketInformationResponseDTO toTicketInformationResponseDTO(TicketDomain ticketDomain) {
        return new TicketInformationResponseDTO(
                ticketDomain.getIncidentId(),
                ticketDomain.getTicketId(),
                ticketDomain.getTicketName()
        );
    }
}
