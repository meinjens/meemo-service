package meemo.campaigns

import meemo.campaigns.entities.Campaign
import meemo.config.Logging
import meemo.config.logger
import org.springframework.stereotype.Service

@Service
class CampaignInteractor : CampaignService, Logging {

    override fun findCampaigns(tenantId: Long): List<Campaign> {
        logger().info("Geht doch")

        TODO("Not yet implemented")
    }

    override fun createCampaign(tenantId: Long, campaign: Campaign) {
        TODO("Not yet implemented")
    }


}