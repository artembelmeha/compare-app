package com.ukd.userapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "relational-user-service")
public interface RelationUserServiceClient {

    @GetMapping("/users")
    String getAll();
}
