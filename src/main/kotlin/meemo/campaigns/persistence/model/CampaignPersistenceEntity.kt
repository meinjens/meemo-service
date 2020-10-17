package meemo.campaigns.persistence.model

import meemo.campaigns.entities.Campaign
import meemo.campaigns.entities.CampaignState
import meemo.tenants.Tenant
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class CampaignPersistenceEntity(
        val tenantId: Long,
        val name: String,
        val description: String? = null,
        val updatedAt: LocalDateTime = LocalDateTime.now(),
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val state: CampaignState,
        @Id val id: Long? = null) {

    companion object {
        fun fromEntity(campaign: Campaign) = CampaignPersistenceEntity(
                campaign.tenant.id,
                campaign.name,
                campaign.description,
                campaign.createdAt,
                campaign.updatedAt,
                campaign.state)
    }

    fun toEntity(): Campaign {
        return Campaign(Tenant(tenantId, "unknown"),name, description)
    }
}




