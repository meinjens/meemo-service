package meemo.campaigns

import meemo.campaigns.entities.Campaign
import meemo.tenants.Tenant
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CampaignTest {

    @Test
    fun `given Campaign when archive then Campaign should be archived`() {
        val campaign = Campaign(
                Tenant(1, "test"),
                "test",
                "test description")

        campaign.archive()

        assertThat(campaign.archived).isTrue
    }
}