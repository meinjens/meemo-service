package meemo.campaigns.entities

import meemo.items.Item
import meemo.tenants.Tenant
import meemo.users.User
import java.time.LocalDateTime

class Campaign(
        var tenant: Tenant,
        var name: String,
        description: String?
) {
    var items = mutableListOf<Item>()
    var owner: User? = null
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