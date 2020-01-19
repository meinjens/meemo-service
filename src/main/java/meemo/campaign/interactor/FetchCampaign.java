package meemo.campaign.interactor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import meemo.campaign.boundary.FetchCampaignBoundary;
import meemo.campaign.gateway.CampaignPersistence;
import meemo.model.Campaign;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FetchCampaign implements FetchCampaignBoundary {

    @NonNull
    private CampaignPersistence campaignPersistence;

    @Override
    public List<Campaign> fetchList() {
        return campaignPersistence.fetchList();
    }


    public void setCampaignPersistence(CampaignPersistence campaignPersistence) {
        this.campaignPersistence = campaignPersistence;
    }

}
