package meemo.items

import meemo.service.api.ItemsApiService
import meemo.service.api.model.ErrorModel
import meemo.service.api.model.ItemModel
import org.springframework.stereotype.Service

@Service
class ItemController : ItemsApiService {
    override suspend fun createItem(campaignId: String, itemModel: ItemModel) {
        TODO("Not yet implemented")
    }

    override suspend fun getItem(campaignId: String, itemId: Int): ErrorModel {
        TODO("Not yet implemented")
    }

    override suspend fun getItems(campaignId: String): ErrorModel {
        TODO("Not yet implemented")
    }

    override suspend fun removeItem(campaignId: String, itemId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun updateItem(campaignId: String, itemId: Int): ErrorModel {
        TODO("Not yet implemented")
    }

}