package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop_table")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Generation")
    private int generation;

    @Column(name = "Processor")
    private String processor;

    @Column(name = "RAM")
    private int ram;

    @Column(name = "Price")
    private double price;

    @Column(name = "IMEI")
    private long imei;

    public Laptop() {}

    public Laptop(String brand, int generation, String processor, int ram, double price, long imei) {
        this.brand = brand;
        this.generation = generation;
        this.processor = processor;
        this.ram = ram;
        this.price = price;
        this.imei = imei;
    }

    public Laptop( int generation, String processor, int ram, double price, long imei) {
        this.generation = generation;
        this.processor = processor;
        this.ram = ram;
        this.price = price;
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "[ID: " + id + " Brand: " + brand + " Generation: " + generation +
                " Processor: " + processor + " RAM: " + ram + " Price: " + price +
                " IMEI: " + imei + "]";
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public int getGeneration() { return generation; }
    public void setGeneration(int generation) { this.generation = generation; }

    public String getProcessor() { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public long getImei() { return imei; }
    public void setImei(long imei) { this.imei = imei; }
}
