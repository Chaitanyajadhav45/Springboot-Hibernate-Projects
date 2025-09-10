package com.example.Dao;

import com.example.entity.Laptop;
import jakarta.transaction.Transactional;

public interface LaptopDAO {

    void save(Laptop laptop);

    Laptop findById(int id);

    Laptop findByImeiNo(long imei);

    @Transactional
    void deletelaptop(int id);

    @Transactional
    void updateGenration(int id, int newGen);

    @Transactional
    void updateProcessor(int id, String newProcessor);

    @Transactional
    void updateRam(int id, int newRam);

    @Transactional
    void updatePrice(int id, double newPrice);
}
