package com.test.service;

import com.test.model.MerchandiseEntity;
import com.test.repo.InventoryRepository;
import com.test.util.MerchandiseUtil;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final MerchandiseUtil merchandiseUtil;

    public InventoryService(final InventoryRepository inventoryRepository,
                            final MerchandiseUtil merchandiseUtil) {
        this.inventoryRepository = inventoryRepository;
        this.merchandiseUtil = merchandiseUtil;
    }

    public MerchandiseEntity saveShirtInventory(Double price, int nameLength) {
        MerchandiseEntity shirt = new MerchandiseEntity(
                price, merchandiseUtil.getShirtName(nameLength));
        return inventoryRepository.save(shirt);
    }
}
