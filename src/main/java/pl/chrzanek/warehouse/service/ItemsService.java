package pl.chrzanek.warehouse.service;

import org.springframework.stereotype.Service;
import pl.chrzanek.warehouse.repository.ItemsRepository;

import pl.chrzanek.warehouse.model.Items;
import java.util.List;
import java.util.Optional;

@Service

public class ItemsService {

    private final ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository) {

        this.itemsRepository = itemsRepository;
    }

    public List<Items> getItems() {
        return itemsRepository.findAll();

    }

    public Items getSingleItem(Integer id) {
        Optional<Items> optional = itemsRepository.findById(id);
        Items items;
        if (optional.isPresent()){
            items = optional.get();
        }else{
            throw new RuntimeException("Item not found for id :: "+id);
        }
        return items;
    }

    public void save(Items items) {
        this.itemsRepository.save(items);
    }


    //public void deleteById(Integer ProductsID) {

    //    itemsRepository.deleteById(ProductsID);
    //}
}




