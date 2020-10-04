package meemo.campaigns.persistence.repository

import meemo.campaigns.persistence.model.CampaignPersistenceEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface CampaignRepository : JpaRepository<CampaignPersistenceEntity, String> {
    fun findByName(name: String): CampaignPersistenceEntity?
}
