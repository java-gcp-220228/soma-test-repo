package com.revature.Track2gether.utility;

import com.revature.Track2gether.model.Categories;
import com.revature.Track2gether.model.Transaction;
import com.revature.Track2gether.model.Transactiontype;
import com.revature.Track2gether.model.Users;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class DataPopulateUtility {
    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void populateIntialData(){
        Transactiontype income =new Transactiontype();
        income.setType("income");
        em.persist(income);

        Transactiontype expense =new Transactiontype();
        expense.setType("expense");
        em.persist(expense);

    //Category

    Categories salary =new Categories();
    salary.setCategoryname("salary");
    salary.setTranstype(income);
    em.persist(salary);

    Categories investment =new Categories();
    investment.setCategoryname("investment");
    investment.setTranstype(income);
    em.persist(investment);

    Categories other =new Categories();
    other.setCategoryname("other");
    other.setTranstype(income);
    em.persist(other);

    Categories otherexp =new Categories();
    otherexp.setCategoryname("other");
    otherexp.setTranstype(expense);
    em.persist(other);

    Categories housing =new Categories();
    housing.setCategoryname("housing");
    housing.setTranstype(expense);;
    em.persist(housing);

    Categories utilities =new Categories();
    utilities.setCategoryname("utilities");
    utilities.setTranstype(expense);;
    em.persist(utilities);

    Categories food =new Categories();
    food.setCategoryname("food");
    food.setTranstype(expense);
    em.persist(food);

    Categories transportation =new Categories();
    transportation.setCategoryname("transportation");
    transportation.setTranstype(expense);
    em.persist(transportation);

    Categories clothing =new Categories();
    clothing.setCategoryname("clothing");
    clothing.setTranstype(expense);
    em.persist(clothing);

    Users user1 = new Users();
    user1.setFirstname("soma");
    user1.setLastname("jan");
    user1.setEmail("soma.j8@gmail.com");
    em.persist(user1);

    Users user2 = new Users();
    user2.setFirstname("lixy");
    user2.setLastname("mat");
    user2.setEmail("abc.j8@gmail.com");
    em.persist(user2);

    user2.setSpouseId(user1);
    user1.setSpouseId(user2);


}   }
