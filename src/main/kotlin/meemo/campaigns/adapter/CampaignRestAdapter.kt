package meemo.campaigns.adapter

import kotlinx.coroutines.flow.Flow
import meemo.campaigns.CampaignService
import meemo.campaigns.entities.Campaign
import meemo.service.api.CampaignsApiService
import meemo.service.api.model.CampaignModel
import meemo.tenants.Tenant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CampaignRestAdapter (
        @Autowired val campaignService: CampaignService
) : CampaignsApiService {
    override suspend fun archiveCampaign(campaignId: String): CampaignModel {
        TODO("Not yet implemented")
    }

    override suspend fun createCampaign(campaignModel: CampaignModel): CampaignModel {
        // Get Request

        // Create Campaign
        campaignService.createCampaign(1, Campaign(Tenant(1, "test"), "test", "test"))
        //campaignService.createCampaign()

        // Render Response
        //return CreateCampaignResposnse
        TODO("Not finished")
    }

    override suspend fun deleteCampaign(campaignId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun duplicateCampaign(campaignId: String): CampaignModel {
        TODO("Not yet implemented")
    }

    override fun findCampaigns(limit: Int?): Flow<CampaignModel> {
        TODO("Not yet implemented")
    }

    override suspend fun readCampaign(campaignId: String): CampaignModel {
        TODO("Not yet implemented")
    }

    override suspend fun unarchiveCampaign(campaignId: String): CampaignModel {
        TODO("Not yet implemented")
    }

    override suspend fun updateCampaign(campaignId: String, campaignModel: CampaignModel): CampaignModel {
        TODO("Not yet implemented")
    }




}

