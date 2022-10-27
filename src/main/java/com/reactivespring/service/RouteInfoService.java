package com.reactivespring.service;

import com.reactivespring.domain.ContainerDTO;
import com.reactivespring.repository.ContainerInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RouteInfoService {
    @Autowired
    private ContainerInfoRepository containerInfoRepository;

    public Mono<ContainerDTO> addContainerInfo(ContainerDTO containerDTO) {
        log.info("Recieved containerDTO Object :{}", containerDTO);
        return containerInfoRepository.save(containerDTO).log();
    }

    public Mono<Double> getNoOfContainersBySourceAndContainerType(String source, String containerType) {
        log.info("At Service :Received Container  Request for {}:{}", source, containerType);
        Mono<ContainerDTO> containerDTO = containerInfoRepository.findNoOfContainersBySourceAndContainerType(source,containerType);
        //return containerDTO.getNoOfContainers();
        return  containerDTO.flatMap(e-> Mono.just(e.getNoOfContainers()));
    }
}
