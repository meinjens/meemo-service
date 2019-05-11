package meemo.campaign.service.controller;

import lombok.extern.slf4j.Slf4j;
import meemo.api.CampaignApi;
import meemo.model.Campaign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@Slf4j
public class CampaignsApiController implements CampaignApi {

    @Override
    public Mono<ResponseEntity<Flux<Campaign>>> getCampaigns(ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok().body(Flux.just(new Campaign())));
    }
}
