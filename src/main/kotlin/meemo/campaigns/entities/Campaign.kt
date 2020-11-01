package meemo.campaigns.entities

import meemo.tenants.Tenant
import java.time.LocalDateTime

class Campaign(
        var tenant: Tenant,
        var name: String
) {
    var description: String? = null
    var createdAt: LocalDateTime = LocalDateTime.now()
    var updatedAt: LocalDateTime = LocalDateTime.now()
    var state: CampaignState = CampaignState.DRAFT
    var archived: Boolean = false


    fun archive() {
        archived = true
    }

    fun unarchived() {
        archived = false
    }
}