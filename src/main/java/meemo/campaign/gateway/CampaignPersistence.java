package meemo.campaign.gateway;

import meemo.model.Campaign;

import java.util.List;

public interface CampaignPersistence {
    List<Campaign> fetchList();
}
