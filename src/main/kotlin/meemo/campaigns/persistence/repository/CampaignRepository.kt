package meemo.campaigns.persistence.repository

import meemo.campaigns.persistence.model.CampaignPersistenceEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CampaignRepository : ReactiveCrudRepository<CampaignPersistenceEntity, String> {
    fun findByName(name: String): Flux<CampaignPersistenceEntity>
}
