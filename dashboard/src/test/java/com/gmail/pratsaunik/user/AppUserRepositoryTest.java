package com.gmail.pratsaunik.user;

import com.gmail.pratsaunik.WebAppTestConfiguration;
import com.gmail.pratsaunik.pojo.AppUser;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebAppTestConfiguration.class)
public class AppUserRepositoryTest {

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void save() {
    }

    @Test
    @Transactional
    @Sql(value ="/test-appuser.sql")
    public void findUserByLogin() {
        AppUser appUser=sessionFactory.getCurrentSession()
                .createQuery("from AppUser where username like :param1", AppUser.class)
                .setParameter("param1", "test")
                .getSingleResult();
        assertNotNull(appUser);
        assertEquals("12345",appUser.getPassword());


    }
}