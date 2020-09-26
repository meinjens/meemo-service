package meemo.campaigns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class CampaginRepositoryTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val campaignRepository: CampaignRepository) {

    @Test
    fun `When findByName then return Campaign`() {
        val campaignEntity = CampaignEntity("test")
        entityManager.persist(campaignEntity)
        entityManager.flush()
        val found = campaignRepository.findByName("test")
        assertThat(found).isEqualTo(campaignEntity)
    }

}