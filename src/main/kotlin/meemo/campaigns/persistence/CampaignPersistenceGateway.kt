package meemo.campaigns.persistence

import meemo.campaigns.entities.Campaign
import meemo.campaigns.persistence.repository.CampaignRepository
import org.slf4j.Logger
import org.springframework.stereotype.Service
import javax.transaction.Transactional

interface CampaignPersistenceGateway {
    fun createCampaign(campaign: Campaign): Campaign?
    fun retrieveCampaign(campaign: Campaign): Campaign?
    fun retrieveCampaigns(): List<Campaign>
    fun updateCampaign(name: String, updatedCampaign: Campaign): Campaign?
    fun deleteCampaign(name: String): Boolean
}