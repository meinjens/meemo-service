package meemo.campaign.service.gateway;

import meemo.model.Campaign;

import java.util.List;

public interface CampaignPersistence {
    List<Campaign> fetchList();
}
