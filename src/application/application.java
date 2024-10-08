package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class application {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);
        System.out.println("=== TEST 1: seller findById ==== ");
        System.out.println(seller);
        System.out.println("****************************");
        System.out.println("=== TEST 2: seller findByDepartment ==== ");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj:
             list) {
            System.out.println(obj);
        }
        System.out.println("****************************");
        System.out.println("=== TEST 3: seller findAll ==== ");
        list = sellerDao.findAll();
        for (Seller obj:
                list) {
            System.out.println(obj);
        }

        System.out.println("****************************");
        System.out.println("=== TEST 4: seller insert ==== ");
        Seller newSeller = new Seller(null, "Abdullah", "abdullah@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new id = " + newSeller.getId());

        System.out.println("****************************");
        System.out.println("=== TEST 5: seller update ==== ");
        seller = sellerDao.findById(1);
        seller.setName("Martha waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");


        System.out.println("****************************");
        System.out.println("=== TEST 5: seller delete ==== ");
        System.out.println("Entre id for delete test:");
        Integer id = scanner.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Seller with "+ id + " is deleted");
        scanner.close();
    }
}
