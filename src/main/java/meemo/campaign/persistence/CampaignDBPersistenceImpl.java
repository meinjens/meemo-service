package meemo.campaign.persistence;

import meemo.campaign.gateway.CampaignPersistence;
import meemo.model.Campaign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CampaignDBPersistenceImpl implements CampaignPersistence {

    private List<Campaign> storage = new ArrayList<>();

    @Override
    public List<Campaign> fetchList() {
        return storage;
    }
}
