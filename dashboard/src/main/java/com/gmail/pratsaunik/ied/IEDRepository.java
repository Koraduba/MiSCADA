package com.gmail.pratsaunik.ied;

import com.gmail.pratsaunik.pojo.CurrentSensor;
import com.gmail.pratsaunik.pojo.IED;
import com.gmail.pratsaunik.pojo.SensorValue;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class IEDRepository {

    @Autowired
    SessionFactory sessionFactory;

/*
    public List<IED> findProduct() {

        return sessionFactory.getCurrentSession()
                .createQuery("from IED ied",IED.class)
                .list();
    }

    public List<ProductItem> findProductByName(String searchStr) {

        return sessionFactory.getCurrentSession()
                .createQuery("from ProductItem pi where pi.name like :param1", ProductItem.class)
                .setParameter("param1", "%" + searchStr + "%")
                .setMaxResults(10)
                .list();
       return catalog.stream()
                .filter(productItem -> productItem.getName().toLowerCase().contains(searchStr.toLowerCase()))
                .collect(Collectors.toList());
    }

    public ProductItem findProductById(Long id) {

        return sessionFactory.getCurrentSession()
                .get(ProductItem.class, id);
       return catalog.stream()
                .filter(productItem -> productItem.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }*/

    public void save(IED ied) {

        sessionFactory.getCurrentSession()
                .persist(ied);

/*        catalog.add(productItem);*/
    }

    public List<IED> getAllIED() {

        return sessionFactory.getCurrentSession()
                .createQuery("from IED ied",IED.class)
                .list();
    }

    public IED fndIEDbyId(Long id) {
        return sessionFactory.getCurrentSession()
                .get(IED.class, id);
    }

    public CurrentSensor findSensorbyId(Long id) {
        return sessionFactory.getCurrentSession()
                .get(CurrentSensor.class, id);
    }


    public void update(IED ied) {
        sessionFactory.getCurrentSession()
                .update(ied);
    }

    public List<SensorValue> getSensorValues(Long id, int i) {
        return sessionFactory.getCurrentSession()
                .createQuery("from SensorValue sv where sv.currentSensor.sensorId like: param1",SensorValue.class)
                .setParameter("param1",id)
                .setMaxResults(i)
                .list();
    }
/*
    public List<ProductItem> findProductByDate(Date lastDate) {

        return (List<ProductItem>) sessionFactory.getCurrentSession()
                .createQuery("from ProductItem pi where pi.updateDate > :param", ProductItem.class )
                .setParameter("param",lastDate).list();
    }

   public Long getMaxId() {
        return catalog.stream()
                .mapToLong(ProductItem::getId)
                .max().getAsLong();

    }*/
}