package meemo.campaigns

import org.springframework.stereotype.Component
import java.time.LocalDate

interface CreateCampaignBoundary

@Component
class CreateCampaign : CreateCampaignBoundary {
    fun execute(campaign: Campaign) {
        campaign.createdAt = LocalDate.now()
        campaign.state = CampaignState.ACTIVE
    }

}