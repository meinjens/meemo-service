package meemo.campaigns

import meemo.campaigns.entities.Campaign


interface CampaignService {

    fun findCampaigns(tenantId: Long): List<Campaign>

    fun createCampaign(tenantId: Long, campaign: Campaign)

}