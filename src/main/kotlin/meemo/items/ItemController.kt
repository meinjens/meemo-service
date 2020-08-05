package meemo.items

import meemo.service.api.ItemsApiService
import meemo.service.api.model.Error
import meemo.service.api.model.Item
import org.springframework.stereotype.Service

@Service
class ItemController : ItemsApiService {
    override suspend fun createItem(campaignId: String, item: Item) {
        TODO("Not yet implemented")
    }

    override suspend fun getItem(campaignId: String, itemId: Int): Error {
        TODO("Not yet implemented")
    }

    override suspend fun getItems(campaignId: String): Error {
        TODO("Not yet implemented")
    }

    override suspend fun removeItem(campaignId: String, itemId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun updateItem(campaignId: String, itemId: Int): Error {
        TODO("Not yet implemented")
    }

}