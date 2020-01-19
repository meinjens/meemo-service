package meemo.campaign.boundary;

import meemo.model.Campaign;

import java.util.List;

public interface FetchCampaignBoundary {
    List<Campaign> fetchList();
}
