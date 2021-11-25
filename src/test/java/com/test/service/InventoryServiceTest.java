package com.test.service;

import com.test.model.MerchandiseEntity;
import com.test.repo.InventoryRepository;
import com.test.util.MerchandiseUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class InventoryServiceTest {

    @Mock
    MerchandiseUtil merchandiseUtil;

    @Mock
    InventoryRepository inventoryRepository;

    InventoryService inventoryService;

    @Before
    public void setup() {
        inventoryService = new InventoryService(inventoryRepository, merchandiseUtil);
    }

    @Test
    @Ignore
    public void saveShirtInventory() {
        Mockito.when(merchandiseUtil.getShirtName(Mockito.any())).thenReturn("12345");
        Assert.assertEquals(100.5, inventoryService.saveShirtInventory(100.5, 5).getPrice(), 0.0001);
    }

    @Test
    @Ignore
    public void saveShirtInventory_WhenRepoIsMocked() {
        Mockito.when(merchandiseUtil.getShirtName(Mockito.any())).thenReturn("12345");
        Mockito.when(inventoryRepository.save(Mockito.any())).thenReturn(new MerchandiseEntity(1L, 100.5, "brand"));
        MerchandiseEntity merchandiseEntity = inventoryService.saveShirtInventory(100.5, 5);
        Assert.assertEquals(100.5, merchandiseEntity.getPrice(), 0.0001);
    }
}