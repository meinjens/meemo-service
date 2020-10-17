package meemo.campaigns.persistence

import meemo.campaigns.entities.Campaign
import meemo.campaigns.persistence.model.CampaignPersistenceEntity
import meemo.campaigns.persistence.repository.CampaignRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.io.IOException

@Service
internal class CampaignDBPersistence(val repository: CampaignRepository) : CampaignPersistenceGateway {
    val log: Logger = LoggerFactory.getLogger(javaClass)

    @Transactional
    override fun createCampaign(campaign: Campaign): Mono<Campaign> {
        log.debug("Adding Campaign: {}", campaign.name)

        val savedCampaign = repository.save(CampaignPersistenceEntity.fromEntity(campaign))

        return savedCampaign.map { it.toEntity() }
    }

    override fun retrieveCampaign(campaign: Campaign): Mono<Campaign> {
        log.debug("Retrieving campaign: {}", campaign.name)

        val retrievedCampaign = repository.findByName(campaign.name)

        return retrievedCampaign.map { it.toEntity() }.toMono()
    }

    override fun retrieveCampaigns(): Flux<Campaign> {
        log.debug("Retrieving campaigns")

        return repository.findAll().map { it.toEntity() }
    }

    @Transactional
    override fun updateCampaign(name: String, updatedCampaign: Campaign): Mono<Campaign> {
        log.debug("Updating city: {} with data: {}", name, updatedCampaign.name)

        val savedCampaign = repository.save(CampaignPersistenceEntity.fromEntity(updatedCampaign))

        return savedCampaign.map { it.toEntity() }
    }

    @Transactional
    override fun deleteCampaign(name: String): Boolean {
        return try {
            repository.deleteById(name)
            true
        } catch (e: IOException) {
            false
        }
    }

}