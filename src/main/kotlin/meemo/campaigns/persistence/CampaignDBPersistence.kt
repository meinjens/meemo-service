package meemo.campaigns.persistence

import meemo.campaigns.entities.Campaign
import meemo.campaigns.persistence.model.CampaignPersistenceEntity
import meemo.campaigns.persistence.repository.CampaignRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.IOException
import javax.transaction.Transactional

@Service
@Transactional
internal class CampaignDBPersistence(val repository: CampaignRepository) : CampaignPersistenceGateway {
    val log: Logger = LoggerFactory.getLogger(javaClass)

    override fun createCampaign(campaign: Campaign): Campaign {
        log.debug("Adding Campaign: {}", campaign.name)

        return repository.save(CampaignPersistenceEntity.fromEntity(campaign)).toEntity()
    }

    override fun retrieveCampaign(campaign: Campaign): Campaign? {
        log.debug("Retrieving campaign: {}", campaign.name)

        return repository.findByName(campaign.name)?.toEntity()
    }

    override fun retrieveCampaigns(): List<Campaign> {
        log.debug("Retrieving campaigns")

        return repository.findAll().map { it.toEntity() }
    }

    override fun updateCampaign(name: String, updatedCampaign: Campaign): Campaign? {
        log.debug("Updating city: {} with data: {}", name, updatedCampaign.name)

        val oldCampaign = repository.findByName(name)
        return if (oldCampaign != null) repository.save(CampaignPersistenceEntity.fromEntity(updatedCampaign)).toEntity()
        else null
    }

    override fun deleteCampaign(name: String): Boolean {
        return try {
            repository.deleteById(name)
            true
        }
        catch(e: IOException) {
            false
        }
    }

}