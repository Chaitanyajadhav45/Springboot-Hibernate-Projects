package com.example.Dao.DaoImpl;

import com.example.Dao.LaptopDAO;
import com.example.entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopDaoImpl implements LaptopDAO {

    private final EntityManager entityManager;

    public LaptopDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Laptop laptop) {
        entityManager.persist(laptop);
    }

    @Override
    public Laptop findById(int id) {
        return entityManager.find(Laptop.class, id);
    }

    @Override
    @Transactional
    public void deletelaptop(int id) {
        Laptop laptop = entityManager.find(Laptop.class, id);
        if (laptop != null) {
            entityManager.remove(laptop);
            System.out.println("Laptop deleted successfully!");
        } else {
            System.out.println("Laptop not found!");
        }
    }

    @Override
    public Laptop findByImeiNo(long theimeiNo) {
        try {
            Query query = entityManager.createQuery("SELECT l FROM Laptop l WHERE l.imei = :imeiNo");
            query.setParameter("imeiNo", theimeiNo);
            return (Laptop) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public void updateGenration(int id, int newGen)
    {
        Laptop laptop = entityManager.find(Laptop.class , id);
        if (laptop!=null){
            laptop.setGeneration(newGen);
            entityManager.merge(laptop);
            System.out.println("Genration Updated Successfully !!");
        }
        else {
            System.out.println("Laptop not found!");
        }
    }

    @Transactional
    @Override
    public void updateProcessor(int id, String newProcessor) {
        Laptop laptop = entityManager.find(Laptop.class, id);
        if (laptop != null) {
            laptop.setProcessor(newProcessor);
            entityManager.merge(laptop);
            System.out.println("Processor Updated Successfully !!");
        } else {
            System.out.println("Laptop not found!");
        }
    }

    @Transactional
    @Override
    public void updateRam(int id, int newRam) {
        Laptop laptop = entityManager.find(Laptop.class, id);
        if (laptop != null) {
            laptop.setRam(newRam);
            entityManager.merge(laptop);
            System.out.println("RAM Updated Successfully !!");
        } else {
            System.out.println("Laptop not found!");
        }
    }

    @Transactional
    @Override
    public void updatePrice(int id, double newPrice) {
        Laptop laptop = entityManager.find(Laptop.class, id);
        if (laptop != null) {
            laptop.setPrice(newPrice);
            entityManager.merge(laptop);
            System.out.println("Price Updated Successfully !!");
        } else {
            System.out.println("Laptop not found!");
        }
    }

}
