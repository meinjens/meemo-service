package meemo.campaigns

import meemo.service.api.CampaignsApiService
import meemo.service.api.model.Campaign
import meemo.service.api.model.Error
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController

@Service
class CampaignController : CampaignsApiService {
    override suspend fun archiveCampaign(campaignId: String): Error {
        TODO("Not yet implemented")
    }

    override suspend fun createCampaign(campaign: Campaign) {
        TODO("Not yet implemented")
    }

    override suspend fun duplicateCampaign(campaignId: String): Error {
        TODO("Not yet implemented")
    }

    override suspend fun getCampaign(campaignId: String): Campaign {
        TODO("Not yet implemented")
    }

    override suspend fun getCampaigns(limit: Int?): Error {
        TODO("Not yet implemented")
    }

    override suspend fun removeCampaign(campaignId: String): Error {
        TODO("Not yet implemented")
    }

    override suspend fun unarchiveCampaign(campaignId: String): Error {
        TODO("Not yet implemented")
    }

    override suspend fun updateCampaign(campaignId: String): Error {
        TODO("Not yet implemented")
    }

}