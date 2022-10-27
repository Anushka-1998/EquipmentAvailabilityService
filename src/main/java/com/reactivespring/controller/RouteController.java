package com.reactivespring.controller;

import com.reactivespring.domain.ContainerDTO;
import com.reactivespring.service.RouteInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/v1")
public class RouteController {
    @Autowired
    private RouteInfoService routeInfoService;

    @PostMapping("/containerInfos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ContainerDTO> addContainerInfo(@RequestBody ContainerDTO containerDTO)
    {
        log.info("Recieved containerDTO Object :{}", containerDTO);
        return routeInfoService.addContainerInfo(containerDTO);

    }


    @GetMapping("/containerInfos")
    public Mono<Double> getContainerInfo(@RequestParam("source") String source,
                                        @RequestParam("containerType") String containerType)
    {
        log.info("Recieved containerInfo request for {} :{}", source, containerType);
        return routeInfoService.getNoOfContainersBySourceAndContainerType(source, containerType).log();

    }

}
