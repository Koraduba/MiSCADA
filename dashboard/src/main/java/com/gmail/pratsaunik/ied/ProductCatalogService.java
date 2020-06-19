package com.gmail.pratsaunik.ied;

import com.gmail.pratsaunik.pojo.CurrentSensor;
import com.gmail.pratsaunik.pojo.IED;
import com.gmail.pratsaunik.pojo.SensorValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ProductCatalogService {

    @Autowired
    IEDRepository repository;

    @Transactional
    public List<IED> getAllIED() {
        return repository.getAllIED();
    }

    @Transactional
    public CurrentSensor getSensorById(Long id) {
        return repository.findSensorbyId(id);
    }

    @Transactional
    public IED getIED(Long id) {
        return repository.fndIEDbyId(id);
    }

    @Transactional
    public List<SensorValue> getSensorValues(Long id, int i) {
        return repository.getSensorValues(id,i);
    }
/*
@Transactional
    public List<ProductItem> getTopProducts() {
        return repository.findProduct(6, true);
    }
@Transactional
    public List<ProductItem> searchProduct(String searchStr) {
        return repository.findProductByName(searchStr);
    }
@Transactional
    public ProductItem getProductItem(Long id) {
        return repository.findProductById(id);
    }

@Transactional
    public void saveNewProduct(ProductItem productItem) {
    if (productItem.getUpdateDate()==null){
        productItem.setUpdateDate((new Date()));
    }
/*        if(productItem !=null && productItem.getId()==null){
            Long nextId=repository.getMaxId() +1;
            productItem.setId(nextId);
        }
        repository.save(productItem);
    }
*/
}