package com.reactivespring.repository;


import com.reactivespring.domain.ContainerDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ContainerInfoRepository extends ReactiveMongoRepository<ContainerDTO, String> {
    Mono<ContainerDTO> findNoOfContainersBySourceAndContainerType(String source, String containerType);

}
