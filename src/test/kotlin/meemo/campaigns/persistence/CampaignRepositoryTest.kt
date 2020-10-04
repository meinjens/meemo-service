package meemo.campaigns.persistence

import meemo.campaigns.CampaignState
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.time.LocalDate

@DataJpaTest
class CampaignRepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val campaignRepository: CampaignRepository) {

    @Test
    fun `When findByName then return Campaign`() {
        val campaignEntity = CampaignEntity("test",
                "sample campaign",
                LocalDate.now(),
                LocalDate.now(),
                CampaignState.DRAFT
        )
        entityManager.persist(campaignEntity)
        entityManager.flush()

        val found = campaignRepository.findByName("test")

        assertThat(found).isEqualTo(campaignEntity)
    }

}