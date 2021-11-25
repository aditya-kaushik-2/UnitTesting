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
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class InventoryServiceSpringRunnerTest {

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
    public void saveShirtInventory_WhenRepoIsNotMocked() {
        Mockito.when(merchandiseUtil.getShirtName(Mockito.any())).thenReturn("12345");
        MerchandiseEntity merchandiseEntity = inventoryService.saveShirtInventory(100.5, 5);
        Assert.assertEquals(100.5, merchandiseEntity.getPrice(), 0.0001);
    }

    @Test
    public void saveShirtInventory_WhenRepoIsMocked() {
        Mockito.when(merchandiseUtil.getShirtName(Mockito.any())).thenReturn("12345");
        Mockito.when(inventoryRepository.save(Mockito.any())).thenReturn(new MerchandiseEntity(1L, 100.5, "brand"));
        MerchandiseEntity merchandiseEntity = inventoryService.saveShirtInventory(100.5, 5);
        Assert.assertEquals(100.5, merchandiseEntity.getPrice(), 0.0001);
    }
}