package meemo.campaigns.persistence

import meemo.campaigns.entities.Campaign
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CampaignPersistenceGateway {
    fun createCampaign(campaign: Campaign): Mono<Campaign>
    fun retrieveCampaign(campaign: Campaign): Mono<Campaign>
    fun retrieveCampaigns(): Flux<Campaign>
    fun updateCampaign(name: String, updatedCampaign: Campaign): Mono<Campaign>
    fun deleteCampaign(name: String): Boolean
}