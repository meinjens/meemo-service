package meemo.campaigns.adapter

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import meemo.service.api.CampaignsApiService
import meemo.service.api.model.CampaignModel
import org.springframework.stereotype.Service

@Service
class CampaignRestAdapter: CampaignsApiService {
    override suspend fun archiveCampaign(campaignId: String): CampaignModel {
        return CampaignModel("123456789", "Archived Campaign")
    }

    override suspend fun createCampaign(campaignModel: CampaignModel): CampaignModel {
        // Get Request

        // Create Campaign
        //campaignService.createCampaign(1, Campaign(Tenant(1, "test"), "test", "test"))
        //campaignService.createCampaign()

        // Render Response
        //return CreateCampaignResposnse
        TODO("Not finished")
    }

    override suspend fun deleteCampaign(campaignId: String) {

    }

    override suspend fun duplicateCampaign(campaignId: String): CampaignModel {
        return CampaignModel("9876", "Duplicated Campaign")
    }

    override fun findCampaigns(limit: Int?): Flow<CampaignModel> {
        return listOf(CampaignModel("1", "Campaign 1")).asFlow()
    }

    override suspend fun readCampaign(campaignId: String): CampaignModel {
        return CampaignModel("1", "First Campaign")
    }

    override suspend fun unarchiveCampaign(campaignId: String): CampaignModel {
        throw IllegalArgumentException("someething wrong")
    }

    override suspend fun updateCampaign(campaignId: String, campaignModel: CampaignModel): CampaignModel {
        return CampaignModel("2", "Updated Campaign")
    }
}
