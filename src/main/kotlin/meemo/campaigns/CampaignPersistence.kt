package meemo.campaigns

import org.springframework.data.repository.CrudRepository
import java.util.*
import javax.persistence.*

@Entity
data class CampaignEntity(
        val name: String,
        val description: String? = null,
        val createDate: Date,
        val closedDate: Date,
        val state: CampaignState,
        @Id @GeneratedValue val id: Long? = null
)

interface CampaignRepository : CrudRepository<CampaignEntity, Long> {
        fun findByName(name: String): CampaignEntity?
}
