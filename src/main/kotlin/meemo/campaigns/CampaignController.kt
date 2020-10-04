package meemo.campaigns

import kotlinx.coroutines.flow.Flow
import meemo.service.api.CampaignsApiService
import meemo.service.api.model.Campaign
import meemo.service.api.model.CampaignCreateRequest
import meemo.service.api.model.CampaignResponse
import meemo.service.api.model.Error
import meemo.tenants.Tenant
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController

@Service
class CampaignController : CampaignsApiService {


    override suspend fun archiveCampaign(campaignId: String): Error {
        TODO("Not yet implemented")
    }

    override suspend fun createCampaign(campaignCreateRequest: CampaignCreateRequest) {
        val campaign = campaignCreateRequest.toEntity()

        val createCampaign = CreateCampaign()

        // result = createCampaign(campaign)

        // Render result to API
    }


    override suspend fun duplicateCampaign(campaignId: String): Error {
        TODO("Not yet implemented")
    }

    override fun findCampaigns(limit: Int?): Flow<CampaignResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getCampaign(campaignId: String): CampaignResponse {
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

fun CampaignCreateRequest.toEntity() {
    Campaign(name!!, Tenant("test"))
}
