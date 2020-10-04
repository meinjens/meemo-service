package meemo.campaigns

import meemo.campaigns.entities.Campaign
import meemo.campaigns.persistence.CampaignPersistenceGateway
import org.springframework.stereotype.Service

@Service
class CampaignInteractor(campaignPersistence: CampaignPersistenceGateway) : CampaignService{

    override fun findCampaigns(tenantId: Long): List<Campaign> {
        TODO("Not yet implemented")
    }

    override fun createCampaign(tenantId: Long, campaign: Campaign) {
        TODO("Not yet implemented")
    }


}