package meemo.campaign.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meemo.api.CampaignsApi;
import meemo.campaign.boundary.FetchCampaignBoundary;
import meemo.model.Error;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CampaignsRestController implements CampaignsApi {

    @NonNull
    private FetchCampaignBoundary fetchCampaign;

    @Override
    public Mono<ResponseEntity<Error>> getCampaigns(@Valid Integer limit, ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok().body(new Error()));
    }
}
