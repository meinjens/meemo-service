package meemo.versions

import meemo.service.api.VersionsApiService
import meemo.service.api.model.Error
import meemo.service.api.model.Version
import org.springframework.stereotype.Service

@Service
class VersionsController : VersionsApiService {
    override suspend fun createVersion(campaignId: String, itemId: Int, version: Version) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteVersion(campaignId: String, itemId: Int, version: Int): Error {
        TODO("Not yet implemented")
    }

    override suspend fun getVersion(campaignId: String, itemId: Int, version: Int): Error {
        TODO("Not yet implemented")
    }

    override suspend fun getVersions(campaignId: String, itemId: Int): Error {
        TODO("Not yet implemented")
    }

    override suspend fun updateVersion(campaignId: String, itemId: Int, version: Int): Error {
        TODO("Not yet implemented")
    }


}