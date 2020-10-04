package meemo.versions

import meemo.service.api.VersionsApiService
import meemo.service.api.model.ErrorModel
import meemo.service.api.model.VersionModel
import org.springframework.stereotype.Service

@Service
class VersionsController : VersionsApiService {
    override suspend fun createVersion(campaignId: String, itemId: Int, versionModel: VersionModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteVersion(campaignId: String, itemId: Int, version: Int): ErrorModel {
        TODO("Not yet implemented")
    }

    override suspend fun getVersion(campaignId: String, itemId: Int, version: Int): ErrorModel {
        TODO("Not yet implemented")
    }

    override suspend fun getVersions(campaignId: String, itemId: Int): ErrorModel {
        TODO("Not yet implemented")
    }

    override suspend fun updateVersion(campaignId: String, itemId: Int, version: Int): ErrorModel {
        TODO("Not yet implemented")
    }

}