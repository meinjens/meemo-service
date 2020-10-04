package meemo.campaigns.persistence

import meemo.campaigns.CampaignState
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class CampaignEntity(
        val name: String,
        val description: String? = null,
        val createDate: LocalDate,
        val closedDate: LocalDate,
        val state: CampaignState,
        @Id @GeneratedValue val id: Long? = null
)