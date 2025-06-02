package com.capston_design.fkiller.itoms.service_request_management.service;

import com.capston_design.fkiller.itoms.service_request_management.client.TicketCoreClient;
import com.capston_design.fkiller.itoms.service_request_management.client.dto.request.TicketListRequestDTO;
import com.capston_design.fkiller.itoms.service_request_management.common.exception.BaseException;
import com.capston_design.fkiller.itoms.service_request_management.controller.dto.response.TicketInformationResponseDTO;
import com.capston_design.fkiller.itoms.service_request_management.domain.entity.ticket_information.TicketInformation;
import com.capston_design.fkiller.itoms.service_request_management.domain.ticket.TicketDomain;
import com.capston_design.fkiller.itoms.service_request_management.domain.ticket.TicketMapper;
import com.capston_design.fkiller.itoms.service_request_management.repository.TicketInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TicketInformationServiceImpl implements TicketInformationService {

    private final TicketCoreClient ticketCoreClient;
    private final TicketInformationRepository ticketInformationRepository;
    private final TicketMapper ticketMapper;

    @Override
    @Transactional
    public List<TicketInformationResponseDTO> getTicketList(String acceptorId) {
        return Optional.ofNullable(ticketCoreClient.getTicketList(new TicketListRequestDTO(acceptorId)))
                .map(ticketMapper::toTicketDomainList)
                .map(ticketDomainList -> {
                    ticketInformationRepository.saveAll(ticketMapper.toTicketInformationEntityList(ticketDomainList));
                    return ticketMapper.toTicketInformationResponseDTOList(ticketDomainList);
                })
                .orElse(Collections.emptyList());
    }

    @Override
    public TicketDomain getTicketInformation(UUID ticketId) {
        TicketInformation ticketInformation = ticketInformationRepository.findByTicketId(ticketId)
                .orElseThrow(() -> BaseException.createBaseExceptionWithoutDetail(400, "유효하지 않은 티켓ID 입니다."));
        return ticketMapper.toTicketDomain(ticketInformation);
    }

}
