package com.capston_design.fkiller.itoms.service_request_management.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ticket-core", url = "${TICKET_CORE_URL}")
public class TicketCoreClient {
}
