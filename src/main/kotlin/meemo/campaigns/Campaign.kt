package meemo.campaigns

import meemo.items.Item
import meemo.tenants.Tenant
import meemo.users.User
import java.time.LocalDate

class Campaign(
    var name: String,
    var tenant: Tenant
) {
    var items = mutableListOf<Item>()
    var owner: User? = null
    var description: String? = null
    var createdAt: LocalDate = LocalDate.now()
    var state: CampaignState = CampaignState.DRAFT
    var archived: Boolean = false


    fun archive() {
        archived = true
    }

    fun unarchived() {
        archived = false
    }
}