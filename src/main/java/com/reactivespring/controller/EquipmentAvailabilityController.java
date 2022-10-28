package com.reactivespring.controller;

import com.reactivespring.domain.ContainerDTO;
import com.reactivespring.service.EquipmentAvailabilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/v1")
public class EquipmentAvailabilityController {
    @Autowired
    private EquipmentAvailabilityService equipmentAvailabilityService;

    /**
     * This method adds container details to the database based on source
     * @param containerDTO
     * @return
     */
    @PostMapping("/containerInfos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ContainerDTO> addContainerInfo(@RequestBody ContainerDTO containerDTO)
    {
        log.info("Request received to add containerDTO Object :{}", containerDTO);
        return equipmentAvailabilityService.addContainerInfo(containerDTO);

    }

    /**
     * This method gets noOfContainers from database based on source and containerType
     * @param source
     * @param containerType
     * @return
     */
    @GetMapping("/containerInfos")
    public Mono<Double> getContainerInfo(@RequestParam("source") String source,
                                        @RequestParam("containerType") String containerType)
    {
        log.info("Request received to get noOfContainers based on  source : {} | containerType: {}", source, containerType);
        return equipmentAvailabilityService.getNoOfContainersBySourceAndContainerType(source, containerType).log();
    }

}
