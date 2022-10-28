package com.reactivespring.service;

import com.reactivespring.domain.ContainerDTO;
import com.reactivespring.repository.ContainerInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class EquipmentAvailabilityService {

    @Autowired
    private ContainerInfoRepository containerInfoRepository;

    /**
     * @param containerDTO
     * @return
     */

    public Mono<ContainerDTO> addContainerInfo(ContainerDTO containerDTO) {
        log.info("Saving containerDTO Object :{} to the database", containerDTO);
        return containerInfoRepository.save(containerDTO).log();
    }

    /**
     *
     * @param source
     * @param containerType
     * @return
     */

    public Mono<Double> getNoOfContainersBySourceAndContainerType(String source, String containerType) {
        log.info("Get noOfContainer from database based on source : {} | containerType : {}", source, containerType);
        Mono<ContainerDTO> containerDTO = containerInfoRepository.findNoOfContainersBySourceAndContainerType(source,containerType);
        return  containerDTO.flatMap(e-> Mono.just(e.getNoOfContainers()));
    }
}
