package meemo.campaigns

import meemo.campaigns.Campaign
import meemo.tenants.Tenant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CampaignTest {

    @Test
    fun `testing`() {
        val campaign = Campaign(
                "test",
                Tenant("test"))

        campaign.archive()

        assertThat(campaign.archived).isTrue()
    }
}