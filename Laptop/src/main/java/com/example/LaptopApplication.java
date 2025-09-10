package com.example;

import com.example.Dao.LaptopDAO;
import com.example.entity.Laptop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class LaptopApplication {
    public static void main(String[] args) {
        SpringApplication.run(LaptopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(LaptopDAO laptopDao) {
        return runner -> {
            Scanner sc = new Scanner(System.in);
            boolean flag = true;

            while (flag) {
                System.out.println("\n<<<<<<<<<<<<---- Laptop Menu ---->>>>>>>>>>>>");
                System.out.println("1: Add Laptop");
                System.out.println("2: Get Laptop by Id");
                System.out.println("3: Get Laptop by Imei");
                System.out.println("4: Update Laptop");
                System.out.println("5: Remove Laptop by Id");
                System.out.println("0: Exit");

                System.out.print("Choose option: ");
                int opt = sc.nextInt();
                sc.nextLine();

                switch (opt) {
                    case 0: {
                        System.out.println("Exiting...");
                        flag = false;
                        break;
                    }

                    case 1: {
                        System.out.print("Enter How Many laptops to be Entered: ");
                        int times = sc.nextInt();
                        sc.nextLine();

                        while (times > 0) {
                            System.out.print("Enter Brand: ");
                            String brand = sc.nextLine();

                            System.out.print("Enter Generation: ");
                            int gen = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Processor: ");
                            String pro = sc.nextLine();

                            System.out.print("Enter RAM: ");
                            int ram = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter Price: ");
                            double price = sc.nextDouble();
                            sc.nextLine();

                            System.out.print("Enter IMEI: ");
                            long imei = sc.nextLong();
                            sc.nextLine();

                            Laptop l1 = new Laptop(brand, gen, pro, ram, price, imei);
                            laptopDao.save(l1);
                            times--; // ✅ decrement count
                        }
                        System.out.println("Laptops saved successfully!");
                        break;
                    }

                    case 2: {
                        System.out.print("Enter Id: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        Laptop l2 = laptopDao.findById(id);
                        System.out.println(l2 != null ? l2 : "Laptop not found!");
                        break;
                    }

                    case 3: {
                        System.out.print("Enter Laptop's Imei No: ");
                        long imei = sc.nextLong();
                        sc.nextLine();

                        Laptop byImei = laptopDao.findByImeiNo(imei);
                        System.out.println(byImei != null ? byImei : "Laptop not found!");
                        break;
                    }

                    case 4: {
                        System.out.print("Enter Id to Update: ");
                        int laptopId = sc.nextInt();
                        sc.nextLine();

                        Laptop laptop = laptopDao.findById(laptopId);
                        if (laptop == null) {
                            System.out.println("Laptop not found!");
                            break;
                        }

                        boolean updating = true;
                        while (updating) {
                            System.out.println("\n<<<<<<<<<<<<---- Update Menu ---->>>>>>>>>>>>");
                            System.out.println("1: Update Generation");
                            System.out.println("2: Update Processor");
                            System.out.println("3: Update RAM");
                            System.out.println("4: Update Price");
                            System.out.println("0: Exit to Laptop Menu");

                            System.out.print("Choose option: ");
                            int choice = sc.nextInt();
                            sc.nextLine();

                            switch (choice) {
                                case 0: {
                                    updating = false;
                                    break;
                                }
                                case 1: {
                                    System.out.print("Enter New Generation: ");
                                    int newGen = sc.nextInt();
                                    sc.nextLine();
                                    laptopDao.updateGenration(laptopId, newGen);
                                    break;
                                }
                                case 2: {
                                    System.out.print("Enter New Processor: ");
                                    String newProcessor = sc.nextLine();
                                    laptopDao.updateProcessor(laptopId, newProcessor);
                                    break;
                                }
                                case 3: {
                                    System.out.print("Enter New RAM (GB): ");
                                    int newRam = sc.nextInt();
                                    sc.nextLine();
                                    laptopDao.updateRam(laptopId, newRam);
                                    break;
                                }
                                case 4: {
                                    System.out.print("Enter New Price: ");
                                    double newPrice = sc.nextDouble();
                                    sc.nextLine();
                                    laptopDao.updatePrice(laptopId, newPrice);
                                    break;
                                }
                                default: {
                                    System.out.println("Invalid Option!");
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    case 5: {
                        System.out.print("Enter Id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        laptopDao.deletelaptop(id);
                        System.out.println("Laptop deleted successfully!");
                        break;
                    }

                    default: {
                        System.out.println("Invalid option!");
                        break;
                    }
                }
            }
        };
    }
}
