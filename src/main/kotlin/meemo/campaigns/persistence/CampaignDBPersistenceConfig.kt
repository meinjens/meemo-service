package meemo.campaigns.persistence

import meemo.campaigns.persistence.model.CampaignPersistenceEntity
import meemo.campaigns.persistence.repository.CampaignRepository
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJpaRepositories(basePackageClasses = [CampaignRepository::class])
@EntityScan(basePackageClasses = [CampaignPersistenceEntity::class])
@EnableTransactionManagement
internal class CampaignDBPersistenceConfig