package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("\n=== TESTE 1: findById ====");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("\n=== TESTE 2: findAll ====");
        List<Department> departmentList = new ArrayList<>();
        departmentList = departmentDao.findAll();
        for(Department obj : departmentList){
            System.out.println(obj);
        }

        System.out.println("\n=== TESTE 3: insert ====");
        Department newDepartment = new Department(null, "Music");
      //  departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== TESTE 4: update ===");
        newDepartment = departmentDao.findById(13);
        newDepartment.setName("Games");
        departmentDao.update(newDepartment);
        System.out.println("Update completo!");

        System.out.println("\n=== TESTE 5: delete ===");
        System.out.print("Entre com um Id para deletar: ");
        int id = scan.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deleção completada");
    }
}
