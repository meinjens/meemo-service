package meemo.campaign.service.interactor;

import meemo.campaign.service.boundary.FetchCampaignBoundary;
import meemo.campaign.service.gateway.CampaignPersistence;
import meemo.model.Campaign;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchCampaign implements FetchCampaignBoundary {

    private CampaignPersistence campaignPersistence;

    public List<Campaign> getList() {
        return campaignPersistence.fetchList();
    }

    public void setCampaignPersistence(CampaignPersistence campaignPersistence) {
        this.campaignPersistence = campaignPersistence;
    }
}
