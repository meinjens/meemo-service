package meemo.campaigns.persistence

import org.springframework.data.repository.CrudRepository

interface CampaignRepository : CrudRepository<CampaignEntity, Long> {
    fun findByName(name: String): CampaignEntity?
}
