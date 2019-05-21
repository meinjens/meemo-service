package meemo.campaign.service.interactor;

import meemo.campaign.service.gateway.CampaignPersistence;
import meemo.model.Campaign;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class FetchCampaignTest {

    @Mock
    private CampaignPersistence campaignPersistence;

    private FetchCampaign fetchCampaign;

    @Before
    public void setUp() throws Exception {
        fetchCampaign = new FetchCampaign();
        fetchCampaign.setCampaignPersistence(campaignPersistence);
    }

    @Test
    public void givenGatewayHasNothing_whenFetchCampaign_shouldReturnEmptyList() {
        when(campaignPersistence.fetchList()).thenReturn(Collections.emptyList());

        List<Campaign> campaignList = fetchCampaign.getList();

        assertThat(campaignList.size()).isEqualTo(0);
    }

    @Test
    public void givenGatewayHasAnElement_whenFetchCampaign_shouldReturnListWithCampaign() {
        List<Campaign> aCampaignList = new ArrayList<>();
        aCampaignList.add(new Campaign());
        when(campaignPersistence.fetchList()).thenReturn(aCampaignList);

        List<Campaign> campaignList = fetchCampaign.getList();

        assertThat(campaignList.size()).isGreaterThan(0);
    }
}
