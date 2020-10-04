package meemo.campaigns

import meemo.campaigns.entities.Campaign
import meemo.campaigns.entities.CampaignState
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDateTime

interface CreateCampaignBoundary

@Component
class CreateCampaign : CreateCampaignBoundary {
    fun execute(campaign: Campaign) {
        campaign.createdAt = LocalDateTime.now()
        campaign.state = CampaignState.ACTIVE
    }

}