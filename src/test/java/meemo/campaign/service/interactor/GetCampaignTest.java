package meemo.campaign.service.interactor;

import meemo.model.Campaign;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GetCampaignTest {

    @Test
    public void givenNothing_whenGetCampaign_shouldReturnEmptyList() {
        GetCampaign getCampaign = new GetCampaign();

        List<Campaign> campaignList = getCampaign.getList();

        assertThat(campaignList.size()).isEqualTo(0);
    }
}
