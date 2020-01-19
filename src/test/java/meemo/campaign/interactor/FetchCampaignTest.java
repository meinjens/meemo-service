package meemo.campaign.interactor;

import meemo.campaign.gateway.CampaignPersistence;
import meemo.campaign.interactor.FetchCampaign;
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
        fetchCampaign = new FetchCampaign(campaignPersistence);
        fetchCampaign.setCampaignPersistence(campaignPersistence);
    }

    @Test
    public void givenGatewayHasNothing_whenFetchCampaign_shouldReturnEmptyList() {
        when(campaignPersistence.fetchList()).thenReturn(Collections.emptyList());

        List<Campaign> campaignList = fetchCampaign.fetchList();

        assertThat(campaignList.size()).isEqualTo(0);
    }

    @Test
    public void givenGatewayHasAnElement_whenFetchCampaign_shouldReturnListWithCampaign() {
        when(campaignPersistence.fetchList()).thenReturn(List.of(new Campaign()));

        List<Campaign> campaignList = fetchCampaign.fetchList();

        assertThat(campaignList.size()).isGreaterThan(0);
    }
}
